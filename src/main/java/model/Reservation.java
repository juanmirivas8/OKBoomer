package model;

import java.time.LocalDateTime;

import interfaces.reservations.IReservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation implements IReservation{
	public Reservation(Integer itemID, String dni, Integer id, LocalDateTime withdrawalDate,
					   LocalDateTime expectedReturnDate, LocalDateTime realReturnDate, Boolean status) throws IllegalArgumentException{

		setItemID(itemID);
		setDNI(dni);
		setWithdrawalDate(withdrawalDate);
		setExpectedDevolutionDate(expectedReturnDate);
		setReturnDate(realReturnDate);
		setStatus(status);
		setID(id);

	}

	private Reservation(){

	}

	private Integer itemID;
	private String dni;
	private Integer id;
	@XmlElement
	@XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime withdrawalDate;
	@XmlElement
	@XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime expectedReturnDate;
	@XmlElement
	@XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime realReturnDate;
	private Boolean status;

	@Override
	public LocalDateTime getWithdrawalDate() {
		return withdrawalDate;
	}

	@Override
	public void setWithdrawalDate(LocalDateTime date) throws IllegalArgumentException {
		if(date==null){
			throw new IllegalArgumentException("null value not accepted");
		}
		this.withdrawalDate=date;
	}

	@Override
	public LocalDateTime getExpectedReturnDate() {
		return expectedReturnDate;
	}

	@Override
	public void setExpectedDevolutionDate(LocalDateTime date) throws IllegalArgumentException {
		if(date==null){
			throw new IllegalArgumentException("null value not accepted");
		}else if(date.isBefore(withdrawalDate)){
			throw new IllegalArgumentException("Expected devolution date can not be prior to withdrawal date");
		}
		this.expectedReturnDate=date;
	}

	@Override
	public LocalDateTime getReturnDate() {
		return realReturnDate;
	}

	@Override
	public void setReturnDate(LocalDateTime date) {
		if(date!= null && date.isBefore(withdrawalDate)){
			throw new IllegalArgumentException("Real devolution date can not be prior to withdrawal date");
		}
		this.realReturnDate=date;
	}

	@Override
	public String getDNI() {
		return dni;
	}

	@Override
	public void setDNI(String DNI) throws IllegalArgumentException {
		if(DNI==null||!DNI.matches("[0-9]{8}[A-Z]")) {
			throw new IllegalArgumentException("DNI doesnt match format");
		}else {
			this.dni = DNI;
		}
	}

	@Override
	public Integer getItemID() {
		return itemID;
	}

	@Override
	public void setItemID(Integer id) throws IllegalArgumentException {
		if(id == null || id <= 0){
			throw new IllegalArgumentException("Incorrect id");
		}
		this.itemID=id;
	}

	@Override
	public Boolean getStatus() {
		return status;
	}

	@Override
	public void setStatus(Boolean status) throws IllegalArgumentException {
		if(status==null){
			throw new IllegalArgumentException("null value not accepted");
		}
		this.status=status;
	}

	@Override
	public Integer getID() {
		return this.id;
	}

	@Override
	public void setID(Integer id) throws IllegalArgumentException {
		if(id!=null && id <= 0){
			throw new IllegalArgumentException("Incorrect id");
		}
		this.id=id;
	}

	@Override
	public String toString() {
		return
				"itemID=" + itemID +
				", dni='" + dni + '\'' +
				", id=" + id +
				", withdrawalDate=" + withdrawalDate +
				", expectedReturnDate=" + expectedReturnDate +
				", realReturnDate=" + realReturnDate +
				", status=" + status +
				'}';
	}
}
