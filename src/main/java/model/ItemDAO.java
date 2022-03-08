package model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Item.class)
public class ItemDAO extends interfaces.AbstractDAO<Integer, Item> implements interfaces.products.IItemDAO {

	private static final long serialVersionUID = 1L;
	private static ItemDAO instance = null;
	
	private ItemDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ItemDAO newInstance() {
		if (instance == null) {
			instance = new ItemDAO();
			ItemDAO aux = (ItemDAO)load();
			instance.ddbb = aux.ddbb;
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

	public static ItemDAO load() {
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

}
