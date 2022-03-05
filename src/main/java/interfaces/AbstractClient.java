package interfaces;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import model.Adapters;

@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractClient implements IClient{

	protected Integer age;
	protected String name;
	protected String DNI;
	protected String phoneNumber;
	@XmlElement
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = Adapters.LocalDateTimeBind.class)
	protected LocalDateTime registrationDate;
	
	public abstract void setRegisterTime(LocalDateTime time);
	
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
		AbstractClient other = (AbstractClient) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public String toString() {
		return "[DNI =" + DNI + ",\nname = " + name + ",\nage = " + age + ",\nphoneNumber = " + phoneNumber
				+ ",\nregistration Date = " + registrationDate + "]";
	}

	
	
	
}
