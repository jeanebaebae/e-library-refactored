package main;

public class Book {
    private String title;
    private String author;
    private boolean available;
    
    
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		this.available = true;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}
	
    public String getAuthor() {
        return author;
    }
	
    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

	public Book() {
		// TODO Auto-generated constructor stub
	}

}
