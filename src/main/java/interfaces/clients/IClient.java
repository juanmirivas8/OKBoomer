package interfaces.clients;

import java.io.Serializable;
import java.time.LocalDateTime;


public interface IClient extends Serializable{

	String getName();
	void setName(String name)throws IllegalArgumentException;
	
	String getDNI();
	void setDNI(String dni)throws IllegalArgumentException;
	
	Integer getAge();
	void setAge(Integer age)throws IllegalArgumentException;
	
	String getPhoneNumber();
	void setPhoneNumber(String phoneNumber)throws IllegalArgumentException;
	
	LocalDateTime getRegisterTime();
	void setRegisterTime(LocalDateTime t);
	@Override
	String toString();
	
	
}
