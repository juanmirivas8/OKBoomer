package model;


import java.util.LinkedList;
import java.util.Queue;
/**
 * Clase generada para la generacion de ID automática
 *
 */
public class IDGenerator {

	private Integer count;
	private Queue<Integer> deletedNumbers;
	public IDGenerator() {
		count=1;
		deletedNumbers = new LinkedList<Integer>();
	}
	
	Integer generateKey() {
		Integer retValue = count;
		
		if(!deletedNumbers.isEmpty()) {
			retValue = deletedNumbers.poll();
			
		}else {
			count++;
		}
		return retValue;
	}
	
	void eliminateKey(Integer key) {
		deletedNumbers.add(key);
	}
}
