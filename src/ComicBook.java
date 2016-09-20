/* 
 * Name:  Tyler Tomo Matsushita
 * 		  Tanaka Ruzvidzo
 * Assignment: Final Project
 * Program: Computer Programmer
 */
package application;

public class ComicBook {
    
    private String title, description, genre, author;
    private int rating, id;
    
    // Constructor
    public ComicBook(String title, int rating, String author) {
        setTitle(title);
        setRating(rating);
        setAuthor(author);
	}
    
    public ComicBook(String title, String genre, int rating, String author) {
        setTitle(title);
        setRating(rating);
        setAuthor(author);
        setGenre(genre);
	}
    
    public ComicBook(String title, int rating, String author, String description) {
        setTitle(title);
        setRating(rating);
        setAuthor(author);
        setDescription(description);
	}
    
    public ComicBook(String title, int rating, String author, String genre, String description) {
        setTitle(title);
        setRating(rating);
        setAuthor(author);
        setGenre(genre);
        setDescription(description);
	}

	// Mutator Methods
    public void setTitle(String title){
        if(title == null || title.equals(" ")){
            throw new IllegalArgumentException("Error: A comic title can not" +
                   "be empty and can not be a null object ");
        }else{
            this.title = title;
        }
    }    
    
    public void setRating(int rating){
        if(rating <= 0){
            throw new IllegalArgumentException(" Error: A comic book rating can not be"
                + " 0 or below");
        }else{
            this.rating = rating;
        }
    }
    
    public void setDescription(String description){
       this.description = description;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    
    }
    
    public void  setAuthor(String author){
        this.author = author;
    
    }
    
    // Accessor Methods
    public String getTitle(){
        return title;
    }
    
    public int getId(){
        return id;
    }
    
    public int getRating(){
        return rating;
    }
        
      public String getDescription(){
        return description;
    }
      
      public String getAuthor(){
    	  return author;
      }
      
      public String getGenre(){
    	  return genre;
      }
    
    // toString
    public String toString(){
        return String.format("The comic book you wantis  " + this.title + getId());
    }
    
    public boolean equals(Object o){
        ComicBook c = (ComicBook)o;
        return this.title == c.getTitle();
    }
}
