package interfaces;

import java.io.Serializable;

public interface CRUD<K,V> extends Serializable{

	Boolean add(V v, K k);
	
	Boolean update(V v, K k);
	
	V delete(K k);
	
	V search(K k);

	void save();
	
}
