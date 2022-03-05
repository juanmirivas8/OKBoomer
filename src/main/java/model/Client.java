package model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Client extends interfaces.AbstractClient{

	@SuppressWarnings("unused")
	private Client() {
		
	}
	public Client(String dni,String name,Integer age,String phoneNumber)throws IllegalArgumentException {
		super();
		try {
			this.setName(name);
			this.setDNI(dni);
			this.setAge(age);
			this.setPhoneNumber(phoneNumber);
			this.setRegisterTime(LocalDateTime.now());
		} catch (IllegalArgumentException e) {
			throw e;
		}
		
	}
	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) throws IllegalArgumentException {
		if(name==null||name.isEmpty()) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
		
	}

	@Override
	public String getDNI() {
		
		return this.DNI;
	}

	@Override
	public void setDNI(String dni) throws IllegalArgumentException {
		if(dni==null||!dni.matches("[0-9]{8}[A-Z]")) {
			throw new IllegalArgumentException("DNI no cumple formato");
		}else {
			this.DNI = dni;
		}
		
	}

	@Override
	public Integer getAge() {
		
		return this.age;
	}

	@Override
	public void setAge(Integer age) throws IllegalArgumentException {
		if(age==null||age<=0) {
			throw new IllegalArgumentException("Edad incorrecta");
		}else {
			this.age=age;
		}
		
	}

	@Override
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
		if(phoneNumber==null||!phoneNumber.matches("[0-9]{9}")) {
			throw new IllegalArgumentException("Numero no cumple formato");
		}else {
			this.phoneNumber = phoneNumber;
		}
		
	}

	@Override
	public LocalDateTime getRegisterTime() {
		
		return this.registrationDate;
	}

	@Override
	public void setRegisterTime(LocalDateTime time) {
		this.registrationDate = time;
		
	}
	
	

}
