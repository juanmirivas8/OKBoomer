package interfaces;

import java.util.Calendar;

public abstract class AbstractClient implements IClient{

	private Integer age;
	private String name;
	private String DNI;
	private String phoneNumber;
	private Calendar registrationDate;
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object e);
}
