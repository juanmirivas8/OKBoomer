package interfaces;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *Interfaz de la clase Cliente donde se definen las condiciones de la clase
 *Getters y Setters  
 *
 */
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
	
	@Override
	String toString();
	
	
}
