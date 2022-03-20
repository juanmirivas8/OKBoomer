package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import interfaces.products.IProduct;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Product.class)
public class ProductDAO extends interfaces.AbstractDAO<Integer,Product> implements interfaces.products.IProductDAO{
	
	private static ProductDAO instance= null;
	private static final long serialVersionUID = 1L;
	private IDGenerator keygen;
	private ProductDAO() {
		keygen = new IDGenerator();
	}
	public static ProductDAO newInstance() {
		if(instance == null) {
			instance = new ProductDAO();
			ProductDAO aux = load();
			instance.ddbb = aux.ddbb;
			instance.keygen = aux.keygen;
		}
		return instance;
	}
	
	@Override
	public void save() {
		try {
			JAXBContext contexto = JAXBContext.newInstance(ProductDAO.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(instance, new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/products.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static ProductDAO load() {
		JAXBContext contexto;
		ProductDAO newDDBB = null;
		try {
			contexto = JAXBContext.newInstance(ProductDAO.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    newDDBB = (ProductDAO) um.unmarshal( new File("/home/juanmi_rivas_8/Desktop/OKBoomer/src/main/resources/products.xml") );
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDDBB;
	}

	@Override
	public Collection<Product> listOfItemsByTitle() {
		ArrayList<Product> p = new ArrayList<>(ddbb.values()); 
		p.sort((p1,p2)->p1.getTitle().compareTo(p2.getTitle()));
		return p;
	}

	@Override
	public Collection<Product> listOfItemsByKey() {
		ArrayList<Product> p = new ArrayList<>(ddbb.values()); 
		p.sort((p1,p2)->p1.getID().compareTo(p2.getID()));
		return p;
	}

	@Override
	public Collection<Product> listOfItemsByLength() {
		ArrayList<Product> p = new ArrayList<>(ddbb.values()); 
		p.sort((p1,p2)->p1.getLength().compareTo(p2.getLength()));
		return p;
	}

	@Override
	public Collection<Product> listOfItemsByPrice() {
		ArrayList<Product> p = new ArrayList<>(ddbb.values()); 
		p.sort((p1,p2)->p1.getPrice().compareTo(p2.getPrice()));
		return p;
	}

	@Override
	public Collection<Product> listOfItemsByRating() {
		EnumComparator c = new EnumComparator();
		ArrayList<Product> p = new ArrayList<>(ddbb.values()); 
		//p.sort(c);
		//p.sort((p1,p2)->p1.getRating().compareTo(p2.getRating()));
		p.sort((o1,o2)->{return o1.getRating().getAge()-o2.getRating().getAge();});
		return p;
	}

	@Override
	public Boolean add(IProduct p) {
		p.setID(keygen.generateKey());
		return super.add((Product)p, p.getID());
	}
	
	@Override
	public Product delete(Integer k) {
		if(ddbb.containsKey(k)) {
			keygen.eliminateKey(k);
		}
		return super.delete(k);
	}
}
