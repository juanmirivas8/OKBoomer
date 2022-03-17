package interfaces;

import java.util.Objects;

import model.IDGenerator;
import model.MCRS;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Product")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractProduct implements IProduct{

	protected static IDGenerator keygen = new IDGenerator();
	@XmlAttribute(name = "Titulo")
	protected String title;
	@XmlAttribute(name = "Identificacion", required = true)
	protected Integer id;
	@XmlAttribute(name = "Calificacion")
	protected MCRS rating;
	@XmlAttribute(name = "Duracion")
	protected Integer length;
	@XmlAttribute(name = "Precio")
	protected Double price;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractProduct other = (AbstractProduct) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[Title =" + title + ",\nID = " + id + ",\nRating = " + rating + ",\nLength = " + length
				+ ",\nPrice = " + price + "]";
	}
	
}
