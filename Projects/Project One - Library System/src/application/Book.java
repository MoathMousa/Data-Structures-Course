package application;

public class Book implements Comparable{//this class to initialize books
	
	private String author;
	private String title;
	private String edition;
	private String publisher;
	private double price;
	private int quantity;
	
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getEdition() {
		return edition;
	}
	
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Book() {
		super();
	}

	public Book(String author, String title, String edition, String publisher, double price, int quantity) {
		super();
		setAuthor(author);
		setTitle(title);
		setEdition(edition);
		setPublisher(publisher);
		setPrice(price);
		setQuantity(quantity);
	}

	@Override
	public String toString() {
		return author + ":" + title + ":" + edition + ":" + publisher
				+ ":" + price + ":" + quantity ;
	}
	
	@Override
	public int compareTo(Object o) {
		return title.compareTo((String) o);
	}
	
	
	
	

}
