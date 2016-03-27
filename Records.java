package comicbooksearchengine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Records {
    
    public static void main(String[] args) {
       
        String comicName = "";
        String comicName1 = "";
        int rating = 0;
        int id = 0;
        int deleteId = 0;
        String description = " ";
        
        // creat the comicBookList that will hold the comics
        ArrayList<ComicBook> comicBookList = new ArrayList <ComicBook>();
        ArrayList<ComicBook> updatedComicbookList = new ArrayList <ComicBook>();
        
        Scanner userInput = new Scanner(System.in);
        
        // call the method that will pre add some comics for testing purposes
        preSetComicList(comicBookList);
        
        // this will ask the user 3 time to enter some comics with a title and a rating
        for (int i = 0; i<1; i++){
        System.out.println("Please enter the name of a comic book you would like"
            + " to add");
        
        comicName = userInput.nextLine();
        
        
        System.out.println("Great now please enter a rating");
          rating = userInput.nextInt();
          
         
        // will add the users comics into the array list
        addComic(comicBookList,comicName,rating,id);
        
        }
        
     
       System.out.println("What comic book are you looking for?");
       String searchKey = userInput.nextLine();
      
        
       System.out.println(searchComic(comicBookList,searchKey));
       printComicList(comicBookList);
       
        System.out.println("Would you like to delete a comic?: please enter the name");
        String deleteComic = userInput.nextLine();
        
        updatedComicbookList = deleteComic(comicBookList,deleteComic);
        
        printComicList(updatedComicbookList);
        
        System.out.println("Enter the name of the comic that you would like "
            + "to add a descrption for");
        
        String namedDescription = userInput.nextLine();
        
        System.out.println("Enter your description");
        
        description = userInput.nextLine();
        addDescription(updatedComicbookList,namedDescription,description);
        showDescription(updatedComicbookList,namedDescription);
        
      
     
        
    }
    
   // the method that pre sets the list of comics 
    public static void preSetComicList(ArrayList<ComicBook> comicBookList){
        
        System.out.println("Currently the comic List looks like this:");
        
        ComicBook comicName1 = new ComicBook ("SuperMan",5);
        ComicBook comicName2 = new ComicBook ("Wonder Woman",5);
        ComicBook comicName3 = new ComicBook ("Black Panther",5);
        
        comicBookList.add(comicName1);
        comicBookList.add(comicName2);
        comicBookList.add(comicName3);
       
       
            
        
        
        
        
        
    }
    
    // this method will add a new comic into an array list
    public static void addComic(ArrayList<ComicBook> comicBookList,String comicName1, int rating,int id){
        
        ComicBook comicName = new ComicBook(comicName1,rating);
        comicBookList.add(comicName);
        
        
    }
    
   public static void printComicList(ArrayList<ComicBook> comicBookList){
       
       System.out.println("The List of comic books now looks like this");
       
        for (Iterator<ComicBook> it = comicBookList.iterator(); it.hasNext();) {
            ComicBook comics = it.next();
            System.out.println(comics);
        }
       
   }
   
          
    /*
    This method searches through an array list of comic book objects. It will 
    check if the search key exists in the titles of each comic book in the array list.
    
    The method will return an array list of comic books that represents the comic 
    book indexes of the comic books that has the search key in it's title.
    */
    public static ArrayList<ComicBook> searchComic(ArrayList<ComicBook> comics, String searchKey){
        
        // This is the array list of comics that will be returned.
        ArrayList<ComicBook> comicsWithKeyInTitle = new ArrayList<ComicBook>();
        
        // This loop will check each comic book in the comics array list using
        // searchComicBookTitle method.
        for(int i=0; i<comics.size(); i++){
            if(comics.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase()))
                comicsWithKeyInTitle.add(comics.get(i));
        }
        
        return comicsWithKeyInTitle;
    }
    
    // This method will delete a specfied comic form the comicBook List
    public static ArrayList<ComicBook> deleteComic(ArrayList<ComicBook> comicBookList,String searchKey){
        
        // creates a comicBook variable that will hold the deleted comic to confirm it has been deleted
        ComicBook deletedComic = new ComicBook("random",10);
        
        
       for(int i=0; i<comicBookList.size(); i++){
            if(comicBookList.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase())){
                
                
                deletedComic = comicBookList.get(i);
                    comicBookList.remove(comicBookList.get(i));
              
                }
            }
        
          System.out.println(deletedComic + "has been deleted");
          
        return comicBookList;
       }
    
    public static void addDescription(ArrayList<ComicBook> comicBookList,String searchKey, String description){
        
        
          ComicBook addDescriptionComic = new ComicBook("random",10);
          
         for(int i=0; i<comicBookList.size(); i++){
            if(comicBookList.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase())){
                
                addDescriptionComic  = comicBookList.get(i);
                comicBookList.get(i).setDescription(description);
                }
            }
        
          System.out.println(addDescriptionComic+ " descrption has been added");
        
    }
    public static void showDescription(ArrayList <ComicBook> comicBookList,String searchKey){
        
             
          ComicBook descriptionOfComic = new ComicBook("random",10);
          String comicDescription = "";
          
         for(int i=0; i<comicBookList.size(); i++){
            if(comicBookList.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase())){
                
                
                descriptionOfComic  = comicBookList.get(i);
                 comicDescription = comicBookList.get(i).getDescription();
            
              
                }
            }
        
          System.out.println(descriptionOfComic+ " descrption's is" + comicDescription);
        
    }
}