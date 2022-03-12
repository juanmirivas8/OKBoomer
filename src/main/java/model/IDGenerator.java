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
		if(deletedNumbers == null) {
			deletedNumbers = new LinkedList<Integer>();
		}
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
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Queue<Integer> getDeletedNumbers() {
		return deletedNumbers;
	}

	public void setDeletedNumbers(Queue<Integer> deletedNumbers) {
		this.deletedNumbers = deletedNumbers;
	}

	void eliminateKey(Integer key) {
		if(!deletedNumbers.contains(key)) {
			deletedNumbers.add(key);
		}
		
	}
}
