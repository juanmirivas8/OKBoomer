package model;


import java.util.LinkedList;
import java.util.Queue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
