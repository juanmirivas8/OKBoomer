package model;

import java.io.Serializable;
/*
 * Creacion de una lista enum para obligar al usuario a elegir un 
 * rating que este en la lista y asi evitara excepciones
 */
public enum MCRS implements Serializable{
	MCRS3(3,"Intended for all audiences"),
	MCRS7(7,"Intended for audiences older than 7 years old"),
	MCRS12(12,"Intended for audiences older than 12 years old"),
	MCRS16(16,"Intended for audiences older than 16 years old"),
	MCRS18(18,"Intended for adult audiences");
	
	private final String rating;
	private final Integer age;
	
	private MCRS(Integer age, String rating) {
		this.rating = rating;
		this.age = age;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public String getRating() {
		return this.rating;
	}
}
