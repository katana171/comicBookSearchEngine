package comicbooksearchengine;

public class ComicBook {
    
    private String title, description;
    private int rating, id;
    
    public ComicBook(String title, int rating){
         setTitle(title);
         setRating(rating);
         //setId(id);
    }

    // Setter/Mutator Methods
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
    
    
    // Getter/ Methods
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
    
    // toString
    public String toString(){
        return String.format("The comic book you wantis  " + this.title + getId());
    }
    
    public boolean equals(Object o){
        ComicBook c = (ComicBook)o;
        return this.title == c.getTitle();
    }
}