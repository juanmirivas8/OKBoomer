package model;

public class Product extends interfaces.AbstractProduct{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Product() {
		
	}
	
	public Product(String title,Integer id, Integer length,Double price,MCRS rating) {
		super();
		try {
			this.setTitle(title);
			this.setLength(length);
			this.setPrice(price);
			this.setRating(rating);
		}catch(IllegalArgumentException e) {
			throw e;
		}
	}

	@Override
	public String getTitle() {
		
		return this.title;
	}

	@Override
	public void setTitle(String title) throws IllegalArgumentException {
		if(title==null||title.isEmpty()) {
			throw new IllegalArgumentException("Invalid title");
		}
		this.title = title;
		
	}

	@Override
	public Integer getID() {
	
		return this.id;
	}

	@Override
	public Integer getLength() {
		
		return this.length;
	}

	@Override
	public void setLength(Integer length) throws IllegalArgumentException {
		if(length==null||length<0) {
			throw new IllegalArgumentException("Invalid length");
		}
		this.length = length;
		
	}

	@Override
	public Double getPrice() {
	
		return this.price;
	}

	@Override
	public void setPrice(Double price) throws IllegalArgumentException {
		if(price==null||price<0) {
			throw new IllegalArgumentException("Invalid price");
		}
		this.price = price;
	}

	@Override
	public MCRS getRating() {
		return this.rating;
	}

	@Override
	public void setRating(MCRS rating) throws IllegalArgumentException {
		if(rating==null) {
			throw new IllegalArgumentException("Invalid rating");
		}
		this.rating = rating;
	}
	
	
	
	
	
	
}
