/* 
 * Name:  Tyler Tomo Matsushita
 * 		  Tanaka Ruzvidzo
 * Assignment: Final Project
 * Program: Computer Programmer
 */
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Records {
    
     public static void printComicList(ArrayList<ComicBook> comicBookList){
            for (Iterator<ComicBook> it = comicBookList.iterator(); it.hasNext();) {
                ComicBook comics = it.next();
                System.out.println(comics);
            }
     }
     
     // We probably don't need this here.
     public static String nextRecord(ArrayList<ComicBook> comicBookList){
          String elements = "";
          ListIterator<ComicBook> it = comicBookList.listIterator();
           while(it.hasNext()){
        	   elements =  ("index: " + it.nextIndex() + " value: " + it.next());
        	   // System.out.println("index: " + it.nextIndex() + " value: " + it.next());
           }
           return elements;   
     }
         
     public static ArrayList<ComicBook> searchComic(ArrayList<ComicBook> comics, String searchKey){
    	 
    	
    	 
        ArrayList<ComicBook> ary = new ArrayList<ComicBook>();
        for(int i=0; i<comics.size();i++){
            if(comics.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase()))
                ary.add(comics.get(i));
        }
        return ary;
    }
     
  
     public static ArrayList<ComicBook> deleteComic(ArrayList<ComicBook> comicBookList,String searchKey){
         
         ComicBook deletedComic = new ComicBook("random",10, "bob");
         
        for(int i=0; i<comicBookList.size(); i++){
             if(comicBookList.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase())){
                 
                 deletedComic = comicBookList.get(i);
                     comicBookList.remove(comicBookList.get(i));
               
                 }
             }
         
           System.out.println(deletedComic + "has been deleted");
           
         return comicBookList;   
     }
     
     // test
     public static ArrayList<ComicBook> addComic(ArrayList<ComicBook> comicBookList, String title, String author,int rating, String genre, String description){
         
    	 /*
    	 Boolean g = genre == "null" || title.equals(" ");
    	 Boolean d = description == "null";
    	 
    	 ComicBook comicName;
    	 
    	 if (g && d){comicName = new ComicBook(title,rating,author);}
    	 else if(g && !d){comicName = new ComicBook(title,rating,author, description);}
    	 else if(!g && d){comicName = new ComicBook(title,genre,rating,author);}
    	 else{comicName = new ComicBook(title,rating,author, genre, "work now");}
    	 
         comicBookList.add(comicName);
         
         //
         return comicBookList;
         */
    	 
    	 ComicBook comicName;
    	 comicName = new ComicBook(title,rating,author, genre, description);
    	 comicBookList.add(comicName);
    	 return comicBookList;
     }
     
     // test this
     public static void editComic(ArrayList<ComicBook> comicBookList, int index, String title, String author, int rating, String genre, String description){
         
         comicBookList.get(index).setTitle(title);
         comicBookList.get(index).setAuthor(author);
         comicBookList.get(index).setRating(rating);
         comicBookList.get(index).setGenre(genre);
         comicBookList.get(index).setDescription(description);
     }

     
     // test this
     public static void showDescription(ArrayList <ComicBook> comicBookList,String searchKey){
         
         ComicBook descriptionOfComic = new ComicBook("random",10, "Bob");
         String comicDescription = "";
         
        for(int i=0; i<comicBookList.size(); i++){
           if(comicBookList.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase())){
               
               descriptionOfComic  = comicBookList.get(i);
               comicDescription = comicBookList.get(i).getDescription();
               }
           }
         System.out.println(descriptionOfComic+ " descrption's is" + comicDescription);
     }
     
     // test this
     public static void addDescription(ArrayList<ComicBook> comicBookList,String searchKey, String description){
         
         ComicBook addDescriptionComic = new ComicBook("random",10,"bob");
         
        for(int i=0; i<comicBookList.size(); i++){
           if(comicBookList.get(i).getTitle().toLowerCase().contains(searchKey.toLowerCase())){
               
               addDescriptionComic  = comicBookList.get(i);
               comicBookList.get(i).setDescription(description);
               }
           }
       
         System.out.println(addDescriptionComic+ " descrption has been added");
       
   }
     
     public static ArrayList<ComicBook> preSetComicList(){
         
         ComicBook comicName1 = new ComicBook ("SuperMan",4, "Jerry Siegal", "Action", 
        		 "Superman is a superhero appearing in American comic books published by DC Comics. The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction.");
         ComicBook comicName2 = new ComicBook ("Wonder Woman",3, "William Moulton Marston", "Action",
        		 "Wonder Woman is a warrior princess of the Amazons and is known in her homeland as Princess Diana of Themyscira.");
         ComicBook comicName3 = new ComicBook ("Black Panther",3,"Stan Lee", "Action",
        		 "The Black Panther is a superhero appearing in American comic books published by Marvel Comics.");
         ComicBook comicName4 = new ComicBook ("Batman",4,"Bill Finger", "Action",
        		 "Batman is a superhero appearing in American comic books published by DC Comics.");
         ComicBook comicName5 = new ComicBook ("Calvin and Hobbes",5, "Bill Watterson", "Comedy",
        		 "Calvin and Hobbes follows the humorous antics of Calvin, a precocious, mischievous, and adventurous six-year-old boy, and Hobbes, his sardonic stuffed tiger.");
         ComicBook comicName6 = new ComicBook ("Garfield",4, "Jim Davis", "Comedy",
        		 "Garfield chronicles the life of the title character, the cat Garfield, Jon, his owner, and Jon's dog, Odie.");
         ComicBook comicName7 = new ComicBook ("Archie",3, "Maurice Coyne", "Comedy",
        		 "Archie Comics is an ongoing comic book series featuring the Archie Comics character Archie Andrews.");
         ComicBook comicName8 = new ComicBook ("Dragon Ball Z",5, "Akira Toriyama", "Sci-Fi",
        		 "Dragon ball follows the adventures of the protagonist, Goku, from his childhood through adulthood as he trains in martial arts and explores the world in search of the seven orbs known as the Dragon Balls");
         ComicBook comicName9 = new ComicBook ("X-Men",4, "Maurice Stan Lee", "Action", 
        		 "The X-Men are mutants, a subspecies of humans who are born with superhuman abilities. The X-Men fight for peace and equality between normal humans and mutants in a world where antimutant bigotry is fierce and widespread.");
         ComicBook comicName10 = new ComicBook ("Naruto",4, "Masashi Kishimoto", "Action", 
        		 "Naruto tells the story of Naruto Uzumaki, an adolescent ninja who constantly searches for recognition and dreams to become the Hokage, the ninja in his village who is acknowledged as the leader and the strongest of all.");
         ComicBook comicName11 = new ComicBook ("Bleach",3, "Tite Kubo", "Action",
        		 "Bleach follows the adventures of teenager Ichigo Kurosaki after he obtains the powers of a Soul Reaper.");
         ComicBook comicName12 = new ComicBook ("Spider-Man",4, "Stan Lee", "Action", 
        		 "Lee and Ditko conceived the character as an orphan being raised by his Aunt May and Uncle Ben, and as a teenager, having to deal with the normal struggles of adolescence in addition to those of a costumed crime-fighter.");
         
         
    	 ArrayList<ComicBook> comicBookList = new ArrayList<ComicBook>(
   			  Arrays.asList(
   			    comicName1,comicName2,comicName3,comicName4,comicName5,
   			     comicName6,comicName7, comicName8, comicName9, comicName10, comicName11, comicName12
   			     )
   			  );
    	 return comicBookList;
     }
     
     public static void changePreSetComicList(ArrayList<ComicBook> comicBookList){
    	 
     }
}