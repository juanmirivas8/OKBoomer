package interfaces;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


import model.Client;
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Clase abstracta creada a partir de la interfaz IDDBB
 * 
 *
 */
public abstract class AbstractDataBase implements IDDBB{
	protected HashMap<String, Client> clients;
	//protected HashMap<Integer,Product> products;
	//protected HashMap<Integer,Item> items;
	//protected HashMap<Integer,Reservation> reservations;

}
