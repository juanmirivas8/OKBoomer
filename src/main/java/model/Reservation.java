package model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import interfaces.reservations.IReservation;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation implements IReservation {
	
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime WithdrawalDate;
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime ExpectedReturnDate;
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime ExpectedDevolutionDate;
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime ReturnDate;
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	private LocalDateTime DevolutionDate;
	private String ClientDNI;
	private String ItemID;
	private Boolean Status;
	private Integer ID;
	
	@SuppressWarnings("unused")
	private Reservation() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Reservation(LocalDateTime withdrawalDate, LocalDateTime expectedReturnDate,
			LocalDateTime expectedDevolutionDate, LocalDateTime returnDate, LocalDateTime devolutionDate,
			String clientDNI, String itemID, Boolean status, Integer iD) {
		super();
		WithdrawalDate = withdrawalDate;
		ExpectedReturnDate = expectedReturnDate;
		ExpectedDevolutionDate = expectedDevolutionDate;
		ReturnDate = returnDate;
		DevolutionDate = devolutionDate;
		ClientDNI = clientDNI;
		ItemID = itemID;
		Status = status;
		ID = iD;
	}

	@Override
	public LocalDateTime getWithdrawalDate() {
		// TODO Auto-generated method stub
		return this.WithdrawalDate;
	}

	@Override
	public void setWithdrawalDate(LocalDateTime date) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.WithdrawalDate = date;
	}

	@Override
	public LocalDateTime getExpectedReturnDate() {
		// TODO Auto-generated method stub
		return this.ExpectedReturnDate;
	}

	@Override
	public void setExpectedDevolutionDate(LocalDateTime date) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.ExpectedDevolutionDate = date;
	}

	@Override
	public LocalDateTime getReturnDate() {
		// TODO Auto-generated method stub
		return this.ReturnDate;
	}

	@Override
	public void setDevolutionDate(LocalDateTime date) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.DevolutionDate = date;
	}

	@Override
	public String getClientDNI() {
		// TODO Auto-generated method stub
		return this.ClientDNI;
	}

	@Override
	public void setClientDNI(String DNI) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (DNI == null || !DNI.matches("[0-9]{8}[A-Z]")) {
			throw new IllegalArgumentException("DNI no cumple formato");
			
		} else {
			this.ClientDNI = DNI;
		}
	}

	@Override
	public String getItemID() {
		// TODO Auto-generated method stub
		return this.ItemID;
	}

	@Override
	public void setItemID(Integer id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("ItemID incorrecta");
			
		}else {
			this.ItemID = String.valueOf(id);
		}
	}

	@Override
	public Boolean getStatus() {
		// TODO Auto-generated method stub
		return this.Status;
	}

	@Override
	public void setStatus(Boolean status) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (!status) {
			throw new IllegalArgumentException("Status incorrecto");
			
		} else {
			this.Status = status;
		}
	}

	@Override
	public Integer getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

	@Override
	public void setID() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (ID == null || ID <= 0) {
			throw new IllegalArgumentException("Id incorrecta");
		} else {
			this.ID = ID;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object e) {
		if (this == e)
			return true;
		if (e == null)
			return false;
		if (getClass() != e.getClass())
			return false;
		Reservation other = (Reservation) e;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [WithdrawalDate=" + WithdrawalDate + ", ExpectedReturnDate=" + ExpectedReturnDate
				+ ", ReturnDate=" + ReturnDate + ", ClientDNI=" + ClientDNI + ", ItemID=" + ItemID + ", Status="
				+ Status + ", ID=" + ID + "]";
	}

}
