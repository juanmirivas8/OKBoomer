package model;

import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import interfaces.DAO;
import interfaces.products.IItem;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Item.class)
public class ItemDAO extends DAO<Integer, Item> implements interfaces.products.IItemDAO {

	private static final long serialVersionUID = 1L;
	private static ItemDAO instance = null;
	private IDGenerator keygen;
	
	private ItemDAO() {
		
		keygen = new IDGenerator();
	}
	
	public static ItemDAO newInstance() {
		if (instance == null) {
			instance = new ItemDAO();
				ItemDAO aux = load();
				instance.ddbb = aux.ddbb;
				instance.keygen = aux.keygen;
		}
		return instance;
	}
	
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			JAXBContext c = JAXBContext.newInstance(ItemDAO.class);
			Marshaller m = c.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(instance, new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/item.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ItemDAO load() {
		// TODO Auto-generated method stub
		JAXBContext c;
		ItemDAO newDDBB = null;
		
		try {
			c = JAXBContext.newInstance(ItemDAO.class);
			Unmarshaller um = c.createUnmarshaller();
			
			newDDBB = (ItemDAO) um.unmarshal(new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/item.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDDBB;
	}

	@Override
	public Collection<Item> listOfItemsByKey() {
		// TODO Auto-generated method stub
		ArrayList<Item> i = new ArrayList<>(ddbb.values());
		i.sort(Comparator.comparing(Item::getID));
		return i;
	}

	@Override
	public Collection<Item> listOfItemsByProductKey() {
		// TODO Auto-generated method stub
		ArrayList<Item> i = new ArrayList<>(ddbb.values());
		i.sort( (i1,i2)-> i1.getProductID().compareTo(i2.getProductID()));
		return i;
	}

	@Override
	public Collection<Item> listOfItemsByCondition() {
		// TODO Auto-generated method stub
		ArrayList<Item> i = new ArrayList<>(ddbb.values());
		i.sort((i1,i2)-> i1.getPreservationCondition().compareTo(i2.getPreservationCondition()));
		return i;
	}

	@Override
	public Boolean add(IItem i) {
		Integer key = keygen.generateKey();
		i.setID(key);
		return super.add((Item)i, key);
	}
	
	@Override
	public Item delete(Integer k) {
		if(ddbb.containsKey(k)) {
			keygen.eliminateKey(k);
		}
		return super.delete(k);
	}

	@Override
	public Boolean findProduct(Integer id) {
		for(Item c: ddbb.values()) {
			if(Objects.equals(id, c.getProductID())) {
				return true;
			}
		}
		return false;
	}

}
