package interfaces;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DAO<K,V> implements CRUD<K,V>{

	private static final long serialVersionUID = 1L;
	public HashMap<K,V> ddbb;
	
	public Boolean add(V v,K k) {
		boolean exists = false;
        if (v != null && k != null && !ddbb.containsKey(k)) {
            exists = true;
            ddbb.put(k, v);
        }
        return exists;
	}
	
	public V search(K k) {
		return ddbb.get(k);
	}
	
	public V delete(K k) {
		return ddbb.remove(k);
	}
	
	public Boolean update(V v, K k) {
		Boolean res = false;
		if(v != null && k != null && ddbb.containsKey(k)) {
			ddbb.put(k, v);
			res = true;
		}
		
		return res;
	}
	
	public abstract void save();
		
}
