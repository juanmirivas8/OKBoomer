package interfaces;

import java.io.Serializable;
import java.util.Calendar;

public interface IClient extends Serializable{

	String getName();
	void setName(String name)throws IllegalArgumentException;
	
	String getDNI();
	void setDNI(String dni)throws IllegalArgumentException;
	
	Integer getAge();
	void setAge(Integer age)throws IllegalArgumentException;
	
	String getPhoneNumber();
	void setPhoneNumber(String phoneNumber)throws IllegalArgumentException;
	
	Calendar getRegisterTime();
	void setRegisterTime(Calendar time)throws IllegalArgumentException;
	
	@Override
	String toString();
	
	
}
