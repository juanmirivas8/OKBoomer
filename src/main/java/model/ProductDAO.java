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
@XmlSeeAlso(Product.class)
public class ProductDAO extends interfaces.AbstractDAO<Integer,Product> implements interfaces.products.IProductDAO{
	
	private static ProductDAO instance= null;
	private static final long serialVersionUID = 1L;
	
	private ProductDAO() {
		
	}
	
	public static ProductDAO newInstance() {
		if(instance == null) {
			instance = new ProductDAO();
			ProductDAO aux = (ProductDAO)load();
			instance.ddbb = aux.ddbb;
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
	
	public static ProductDAO load() {
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
}
