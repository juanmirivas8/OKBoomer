package model;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements interfaces.clients.IClient{

	protected Integer age;
	protected String name;
	protected String DNI;
	protected String phoneNumber;
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	protected LocalDateTime registrationDate;
	
	@SuppressWarnings("unused")
	private Client() {
		
	}
	public Client(String dni,String name,Integer age,String phoneNumber)throws IllegalArgumentException {
		super();
		this.setName(name);
		this.setDNI(dni);
		this.setAge(age);
		this.setPhoneNumber(phoneNumber);
		this.setRegisterTime(LocalDateTime.now());

	}
	@Serial
	private static final long serialVersionUID = 1L;

	
	public String getName() {
		return this.name;
	}


	public void setName(String name) throws IllegalArgumentException {
		if(name==null||name.isEmpty()) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
		
	}

	
	public String getDNI() {
		
		return this.DNI;
	}

	
	public void setDNI(String dni) throws IllegalArgumentException {
		if(dni==null||!dni.matches("[0-9]{8}[A-Z]")) {
			throw new IllegalArgumentException("DNI doesnt match format");
		}else {
			this.DNI = dni;
		}
	}

	
	public Integer getAge() {
		
		return this.age;
	}

	
	public void setAge(Integer age) throws IllegalArgumentException {
		if(age==null||age<=0) {
			throw new IllegalArgumentException("Incorrect age");
		}else {
			this.age=age;
		}
		
	}

	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	
	public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
		if(phoneNumber==null||!phoneNumber.matches("[0-9]{9}")) {
			throw new IllegalArgumentException("Number doesnt match format");
		}else {
			this.phoneNumber = phoneNumber;
		}
		
	}

	
	public LocalDateTime getRegisterTime() {
		
		return this.registrationDate;
	}

	
	public void setRegisterTime(LocalDateTime time) {
		if(time==null){
			throw new IllegalArgumentException("null value not accepted");
		}
		this.registrationDate = time;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public String toString() {
		return "DNI = " + DNI + " ,name = " + name + " ,age = " + age + " ,phoneNumber = " + phoneNumber
				+ " ,registration Date = " + registrationDate;
	}
	
	

}
