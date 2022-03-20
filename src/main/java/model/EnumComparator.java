package model;

import java.util.Comparator;

public class EnumComparator implements Comparator<Product> {
	@Override
	public int compare(Product o1, Product o2) {
		
		System.out.println(o1.getRating().getAge()-o2.getRating().getAge());
		return o1.getRating().getAge()-o2.getRating().getAge();
	}
}
