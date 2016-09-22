/*
 * Name:  Tyler Tomo Matsushita
 * 		  Tanaka Ruzvidzo
 * Assignment: Final Project
 * Program: Computer Programmer
 */
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

 public class Main extends Application {

	 // Global Variables used in event handlers
     String theString="";
     String theStringAuthor="";
     int globalRating = 1;
     String globalGenre ="";
     String globalDescription="";
     String theStringGenre;
     String theStringDescription;
     int recordCounter;

     // iterator will iterate through the comic books in the program
     ComicBook cb = new ComicBook("test", 1, "test");
     ArrayList<ComicBook> comics = Records.preSetComicList();
	 ListIterator<ComicBook> itNext = comics.listIterator();

     TextField txtRating = new TextField();

     // Radio Buttons Edit Page
     ToggleGroup radioGroupEditPage = new ToggleGroup();

     RadioButton opt1EditPage = new RadioButton("1");
     RadioButton opt2EditPage = new RadioButton("2");
     RadioButton opt3EditPage = new RadioButton("3");
     RadioButton opt4EditPage = new RadioButton("4");
     RadioButton opt5EditPage = new RadioButton("5");

     // RadioButtons Create Page
     RadioButton optOneCreatePage = new RadioButton("1");
     RadioButton optTwoCreatePage = new RadioButton("2");
     RadioButton optThreeCreatePage = new RadioButton("3");
     RadioButton optFourCreatePage = new RadioButton("4");
     RadioButton optFiveCreatePage  = new RadioButton("5");

     @Override
     public void start(Stage primaryStage) {

    	 // Search Page GUI (The initial startup page)

         // Labels (search page)
    	 // Header label (search page)
         Label lblHeader = new Label("Comicbook Search Engine");
         lblHeader.getStyleClass().add("lblHeader");

         // Blend drop shadow and inner shadow effects
         // to make a fancy title
         Blend blend = new Blend();
         blend.setMode(BlendMode.MULTIPLY);
         DropShadow ds = new DropShadow();
         ds.setColor(Color.rgb(254, 235, 66, 0.3));
         ds.setOffsetX(5);
         ds.setOffsetY(5);
         ds.setRadius(5);
         ds.setSpread(0.2);
         blend.setBottomInput(ds);
         DropShadow ds1 = new DropShadow();
         ds1.setColor(Color.web("#f13a00"));
         ds1.setRadius(20);
         ds1.setSpread(0.2);
         Blend blend2 = new Blend();
         blend2.setMode(BlendMode.MULTIPLY);
         InnerShadow is = new InnerShadow();
         is.setColor(Color.web("#feeb42"));
         is.setRadius(9);
         is.setChoke(0.8);
         blend2.setBottomInput(is);
         InnerShadow is1 = new InnerShadow();
         is1.setColor(Color.web("#f13a00"));
         is1.setRadius(5);
         is1.setChoke(0.4);
         blend2.setTopInput(is1);
         Blend blend1 = new Blend();
         blend1.setMode(BlendMode.MULTIPLY);
         blend1.setBottomInput(ds1);
         blend1.setTopInput(blend2);
         blend.setTopInput(blend1);

         lblHeader.setEffect(blend);

         //Text Fields (search page)
         TextField txtTitle = new TextField(),
         txtAuthor = new TextField(),
         txtGenre = new TextField();
         TextField searchBar = new TextField();

         TextArea txtAreaDescription = new TextArea();
         txtAreaDescription.setWrapText(true);

         txtTitle.setPromptText("Title:");
         txtAuthor.setPromptText("Author:");
         txtGenre.setPromptText("Genre:");
         txtRating.setPromptText("Rating:");
         txtAreaDescription.setPromptText("Description:");

         txtTitle.getStyleClass().add("textFields");
         txtAuthor.getStyleClass().add("textFields");
         txtGenre.getStyleClass().add("textFields");
         txtRating.getStyleClass().add("textFields");
         txtAreaDescription.getStyleClass().add("textFields");
         searchBar.getStyleClass().add("textFields");

         // Buttons (search page)
         Button btnSearch = new Button("Search"),
         btnNewComic = new Button("Create New Comic"),
         btnEdit = new Button("Edit");

         // Image (search page)
         Image logo = new Image("img/Comic-Book-Bam.png");
         ImageView iv1 = new ImageView();
         iv1.setImage(logo);
         iv1.setFitWidth(80);
         iv1.setFitHeight(60);

         Image nextRecord = new Image("img/arrow-right.png");
         ImageView iv2 = new ImageView();
         iv2.setImage(nextRecord);
         Button btnNextRecord = new Button("", iv2);

         Image previousRecord = new Image("img/arrow-left.png");
         ImageView iv3 = new ImageView();
         iv3.setImage(previousRecord);
         Button btnPreviousRecord = new Button("", iv3);

         Image lastRecord = new Image("img/last-record-arrow.png");
         ImageView iv4 = new ImageView();
         iv4.setImage(lastRecord);
         Button btnLastRecord = new Button("", iv4);

         Image firstRecord = new Image("img/first-record-arrow.png");
         ImageView iv5 = new ImageView();
         iv5.setImage(firstRecord);
         Button btnFirstRecord = new Button("", iv5);

         // Panes (Search Page)

         // This is the root
         BorderPane root = new BorderPane();

         // In the top of the root, we will have the title, search bar,
         // search button, and create new comic button.
         GridPane gridPaneForTop = new GridPane();
         gridPaneForTop.add(lblHeader, 1, 1);
         gridPaneForTop.add(searchBar, 1, 2);
         gridPaneForTop.add(btnSearch, 2, 2);
         gridPaneForTop.add(btnNewComic, 4, 2);
         gridPaneForTop.add(iv1,5,1,2,2);

         gridPaneForTop.setHgap(5);
         gridPaneForTop.setVgap(5);

         // In the bottom of the root, we will have the four back/forwards
         // buttons, and the edit button.
         GridPane gridPaneForBottom = new GridPane();
         gridPaneForBottom.add(btnFirstRecord, 1, 1);
         gridPaneForBottom.add(btnPreviousRecord, 2, 1);
         gridPaneForBottom.add(btnNextRecord, 3, 1);
         gridPaneForBottom.add(btnLastRecord, 4, 1);
         gridPaneForBottom.add(btnEdit, 5, 1);

         // In the center of the root, we will have labels (title, author,
         // genre, rating, and description).
         BorderPane centerBorderPane = new BorderPane();
         centerBorderPane.setMaxWidth(Double.MAX_VALUE);
         centerBorderPane.setMaxHeight(Double.MAX_VALUE);

         GridPane comicDataGridPane = new GridPane();
         comicDataGridPane.add(txtTitle, 0,0, 3, 1);
         comicDataGridPane.add(txtAuthor, 0,1, 3, 1);
         comicDataGridPane.add(txtGenre,0,2);
         comicDataGridPane.add(txtRating, 1, 2);

         // sets the spacing for the horizontal and vertical spacing between nodes
         comicDataGridPane.setHgap(5);
         comicDataGridPane.setVgap(5);

         // sets the spacing for the horizontal and vertical spacing between nodes and position
         gridPaneForBottom.setHgap(5);
         gridPaneForBottom.setVgap(5);
         gridPaneForBottom.setAlignment(Pos.CENTER);

         // set the spacing between noded for the grid panes
         Insets mainLabelInset = new Insets(5, 5, 5, 5);

         GridPane.setMargin(txtTitle,mainLabelInset);
         GridPane.setMargin(txtAuthor,mainLabelInset);
         GridPane.setMargin(txtGenre,mainLabelInset);
         GridPane.setMargin(txtRating,mainLabelInset);
         GridPane.setMargin(txtAreaDescription,mainLabelInset);

         GridPane.setMargin(btnPreviousRecord,mainLabelInset);
         GridPane.setMargin(btnNewComic,mainLabelInset);
         GridPane.setMargin(btnNextRecord,mainLabelInset);
         GridPane.setMargin(btnFirstRecord,mainLabelInset);
         GridPane.setMargin(btnLastRecord,mainLabelInset);

         // colmumn constraints for the nodes
         ColumnConstraints col1 = new ColumnConstraints();
         col1.setPercentWidth(50.0);
         comicDataGridPane.getColumnConstraints().addAll(col1, col1);

         txtTitle.setMaxWidth(Double.MAX_VALUE);
         txtTitle.setMaxWidth(Double.MAX_VALUE);


         // add the text box to center of screen
        centerBorderPane.setTop(comicDataGridPane);
        centerBorderPane.setCenter(txtAreaDescription);
        txtAreaDescription.setMaxHeight(Double.MAX_VALUE);

         // add all panes to scene
         root.setTop(gridPaneForTop);
         root.setBottom(gridPaneForBottom);
         root.setCenter(centerBorderPane);

         Scene sceneMain = new Scene(root, 650, 350);

         primaryStage.setTitle("Comic Book Search Engine");
         primaryStage.setScene(sceneMain);

         String stylesheet = getClass().getResource("/res/css/application.css").toExternalForm();
         sceneMain.getStylesheets().add(stylesheet);

         primaryStage.show();




         // Edit Page GUI

         // Labels (edit page)
         Label lblHeaderEditPage = new Label("Comicbook Search Engine");
         Label lblEditComicsTitleEditPage = new Label("Edit Comic Books");
         Label lblTitleEditPage = new Label("Title:");
         Label lblAuthorEditPage = new Label("Author:");
         Label lblGenreEditPage = new Label("Genre:");
         Label lblRatingEditPage = new Label("Rating:");
         Label lblDescriptionEditPage = new Label("Description");

         lblHeaderEditPage.getStyleClass().add("lblHeader");

         // add the blend effect to the title
         lblHeaderEditPage.setEffect(blend);

         lblEditComicsTitleEditPage.getStyleClass().add("labelColor");
         lblTitleEditPage.getStyleClass().add("labelColor");
         lblAuthorEditPage.getStyleClass().add("labelColor");
         lblGenreEditPage.getStyleClass().add("labelColor");
         lblRatingEditPage.getStyleClass().add("labelColor");
         lblDescriptionEditPage.getStyleClass().add("labelColor");

         //Text Fields (edit page)
         TextField txtTitleEditPage = new TextField();
         TextField txtAuthorEditPage = new TextField(),
         txtGenreEditPage = new TextField();

         TextArea txtDescriptionEditPage = new TextArea();
         txtDescriptionEditPage.setWrapText(true);

         txtTitleEditPage.setPromptText("Title:");
         txtAuthorEditPage.setPromptText("Author:");
         txtGenreEditPage.setPromptText("Genre:");
         txtDescriptionEditPage.setPromptText("Description:");

         // Radio Buttons / Toggle group (edit page)
         ToggleGroup radioGroupEditPage = new ToggleGroup();

         opt1EditPage.setToggleGroup(radioGroupEditPage);
         opt2EditPage.setToggleGroup(radioGroupEditPage);
         opt3EditPage.setToggleGroup(radioGroupEditPage);
         opt4EditPage.setToggleGroup(radioGroupEditPage);
         opt5EditPage.setToggleGroup(radioGroupEditPage);

         opt1EditPage.getStyleClass().add("labelColor");
         opt2EditPage.getStyleClass().add("labelColor");
         opt3EditPage.getStyleClass().add("labelColor");
         opt4EditPage.getStyleClass().add("labelColor");
         opt5EditPage.getStyleClass().add("labelColor");

         // Buttons (edit page)
         Button btnBackEditPage= new Button("Back"),
         btnDeleteEditPage = new Button("Delete"),
         btnSaveEditPage = new Button("Save");

         // Panes / Boxes (edit page)
         // This is the root
         BorderPane rootEditPage = new BorderPane();

         // In the top of the root, we will have the main title
         // and edit comics sub title
         GridPane gridPaneForTopEditPage = new GridPane();
         gridPaneForTopEditPage.add(lblHeaderEditPage, 1, 1);
         gridPaneForTopEditPage.add(lblEditComicsTitleEditPage, 4, 1);

         gridPaneForTopEditPage.setHgap(100);
         gridPaneForTopEditPage.setVgap(5);

         // In the bottom of the root, we will have a cancel,
         // delete, and save button.
         GridPane gridPaneForBottomEditPage = new GridPane();
         gridPaneForBottomEditPage.add(btnBackEditPage, 3, 1);
         gridPaneForBottomEditPage.add(btnDeleteEditPage, 4, 1);
         gridPaneForBottomEditPage.add(btnSaveEditPage, 5, 1);

         // HBox for radio buttons
         HBox hBoxForRadioEditPage = new HBox();
         hBoxForRadioEditPage.getChildren().addAll(opt1EditPage,opt2EditPage,opt3EditPage,opt4EditPage,opt5EditPage);


         // In the center of the root (border pane), we will have labels (title, author,
         // genre, rating, and description) which will also be in a BorderPane.
         BorderPane centerBorderPaneEditPage = new BorderPane();
         centerBorderPane.setMaxWidth(Double.MAX_VALUE);
         centerBorderPane.setMaxHeight(Double.MAX_VALUE);

         GridPane comicDataGridPaneEditPage = new GridPane();

         comicDataGridPaneEditPage.add(lblTitleEditPage, 0,0);
         comicDataGridPaneEditPage.add(lblAuthorEditPage, 0,1);
         comicDataGridPaneEditPage.add(lblGenreEditPage,0,2);
         comicDataGridPaneEditPage.add(lblRatingEditPage, 0,3);
         comicDataGridPaneEditPage.add(lblDescriptionEditPage, 0,4);

         comicDataGridPaneEditPage.add(txtTitleEditPage, 1,0);
         comicDataGridPaneEditPage.add(txtAuthorEditPage, 1,1);
         comicDataGridPaneEditPage.add(txtGenreEditPage, 1,2);
         comicDataGridPaneEditPage.add(hBoxForRadioEditPage, 1, 3);
         comicDataGridPaneEditPage.add(txtDescriptionEditPage, 1,4);

         // sets the spacing for the horizontal and vertical spacing between nodes
         comicDataGridPaneEditPage.setHgap(5);
         comicDataGridPaneEditPage.setVgap(5);

         // sets the spacing for the horizontal and vertical spacing between nodes and postion
         gridPaneForBottomEditPage.setHgap(5);
         gridPaneForBottomEditPage.setVgap(5);
         gridPaneForBottomEditPage.setAlignment(Pos.CENTER);

         // set the spacing between noded for the grid panes
         // Insets mainLabelInset = new Insets(5, 5, 5, 5);
         GridPane.setMargin(lblTitleEditPage, mainLabelInset);
         GridPane.setMargin(lblAuthorEditPage, mainLabelInset);
         GridPane.setMargin(lblGenreEditPage, mainLabelInset);
         GridPane.setMargin(lblRatingEditPage, mainLabelInset);
         GridPane.setMargin(lblDescriptionEditPage, mainLabelInset);

         GridPane.setMargin(txtTitleEditPage,mainLabelInset);
         GridPane.setMargin(txtAuthorEditPage,mainLabelInset);
         GridPane.setMargin(txtGenreEditPage,mainLabelInset);
         GridPane.setMargin(txtDescriptionEditPage,mainLabelInset);

         GridPane.setMargin(btnBackEditPage,mainLabelInset);
         GridPane.setMargin(btnDeleteEditPage,mainLabelInset);
         GridPane.setMargin(btnSaveEditPage,mainLabelInset);

         // colmumn constraints for the nodes
         ColumnConstraints col1EditPage = new ColumnConstraints();
         col1EditPage.setPercentWidth(50.0);
         comicDataGridPaneEditPage.getColumnConstraints().addAll(col1EditPage, col1EditPage);

         txtTitleEditPage.setMaxWidth(Double.MAX_VALUE);
         txtTitleEditPage.setMaxWidth(Double.MAX_VALUE);

         // add the text box to center of screen
         centerBorderPaneEditPage.setTop(comicDataGridPaneEditPage);
         centerBorderPaneEditPage.setCenter(txtDescriptionEditPage);
         txtDescriptionEditPage.setMaxHeight(Double.MAX_VALUE);

         // add all panes to scene
         rootEditPage.setTop(gridPaneForTopEditPage);
         rootEditPage.setBottom(gridPaneForBottomEditPage);
         rootEditPage.setCenter(centerBorderPaneEditPage);

         // create scene (edit page)
         Scene sceneEditPage = new Scene(rootEditPage);

 	    sceneEditPage.getStylesheets().add(stylesheet);




         // Create Page GUI

 	    // Label (edit page)
 	    Label lblHeaderCreatePage = new Label ("Comicbook Search Engine");
 	    Label lblPageHeaderCreatePage = new Label ("Create Comic Book");
 	    Label lblTitleCreatePage = new Label("Title:");
 	    Label lblAuthorCreatePage = new Label("Author:");
 	    Label lblGenreCreatePage = new Label("Genre:");
 	    Label lblRatingCreatePage = new Label("Rating:");
 	    Label lblDescriptionCreatePage = new Label("Description:");

 	    lblHeaderCreatePage.getStyleClass().add("lblHeader");
         lblPageHeaderCreatePage.getStyleClass().add("labelColor");
         lblTitleCreatePage.getStyleClass().add("labelColor");
         lblAuthorCreatePage.getStyleClass().add("labelColor");
         lblGenreCreatePage.getStyleClass().add("labelColor");
         lblRatingCreatePage.getStyleClass().add("labelColor");
         lblDescriptionCreatePage.getStyleClass().add("labelColor");

         lblHeaderCreatePage.getStyleClass().add("lblHeader");

         // add blend effect to title
         lblHeaderCreatePage.setEffect(blend);

 	    // Radio Buttons / Toggle group (edit page)
         ToggleGroup radioGroupCreatePage = new ToggleGroup();

         optOneCreatePage.setToggleGroup(radioGroupCreatePage);
         optTwoCreatePage.setToggleGroup(radioGroupCreatePage);
         optThreeCreatePage.setSelected(true);
         optThreeCreatePage.setToggleGroup(radioGroupCreatePage);
         optFourCreatePage.setToggleGroup(radioGroupCreatePage);
         optFiveCreatePage.setToggleGroup(radioGroupCreatePage);

         optOneCreatePage.getStyleClass().add("labelColor");
         optTwoCreatePage.getStyleClass().add("labelColor");
         optThreeCreatePage.getStyleClass().add("labelColor");
         optFourCreatePage.getStyleClass().add("labelColor");
         optFiveCreatePage.getStyleClass().add("labelColor");

 	   // Text nodes (edit page)
 	   TextField txtTitleCreatePage = new TextField();
 	   TextField txtAuthorCreatePage = new TextField();
 	   TextField txtGenreCreatePage = new TextField();
 	   TextArea txtDescriptionCreatePage = new TextArea();
        txtDescriptionCreatePage.setMaxHeight(Double.MAX_VALUE);

        txtDescriptionCreatePage.setWrapText(true);

        // buttons (edit page)
       Button btnCancelCreatePage = new Button("Cancel");
       Button btnSaveCreatePage = new Button("Save");


       // Panes (edit page)
 	    GridPane topPaneCreatePage = new GridPane();
 	    BorderPane rootCreatePage = new BorderPane();
 	    BorderPane centerPaneCreatePage = new BorderPane();
 	    GridPane bottomPaneCreatePage = new GridPane();
 	    HBox buttonsBoxCreatePage = new HBox();

 	    GridPane topGridPaneInCenterCreatePage = new GridPane();

 	    buttonsBoxCreatePage.getChildren().addAll(optOneCreatePage,optTwoCreatePage,optThreeCreatePage,optFourCreatePage,optFiveCreatePage);

 	    lblPageHeaderCreatePage.setAlignment(Pos.TOP_RIGHT);
 	    topPaneCreatePage.add(lblHeaderCreatePage,0,0);
 	    topPaneCreatePage.add(lblPageHeaderCreatePage,1,0);

 	    GridPane.setMargin(lblHeaderCreatePage,mainLabelInset);
         GridPane.setMargin(lblPageHeaderCreatePage,mainLabelInset);
         GridPane.setMargin(lblTitleCreatePage,mainLabelInset);
         GridPane.setMargin(lblAuthorCreatePage,mainLabelInset);
         GridPane.setMargin(lblGenreCreatePage,mainLabelInset);
         GridPane.setMargin(lblRatingCreatePage,mainLabelInset);
         GridPane.setMargin(lblDescriptionCreatePage,mainLabelInset);
         GridPane.setMargin(txtTitleCreatePage,mainLabelInset);
         GridPane.setMargin(txtAuthorCreatePage,mainLabelInset);
         GridPane.setMargin(txtGenreCreatePage,mainLabelInset);

         txtTitleCreatePage.setMaxWidth(Double.MAX_VALUE);
         txtAuthorCreatePage.setMaxWidth(Double.MAX_VALUE);
         txtGenreCreatePage.setMaxWidth(Double.MAX_VALUE);
         topGridPaneInCenterCreatePage.setMaxWidth(450.0);
         GridPane.setHgrow(txtTitleCreatePage, Priority.ALWAYS);

         topGridPaneInCenterCreatePage.add(lblTitleCreatePage, 1, 1);
         topGridPaneInCenterCreatePage.add(txtTitleCreatePage, 2, 1);
         topGridPaneInCenterCreatePage.add(lblAuthorCreatePage, 1, 2);
         topGridPaneInCenterCreatePage.add(txtAuthorCreatePage, 2, 2);
         topGridPaneInCenterCreatePage.add(lblGenreCreatePage, 1, 3);
         topGridPaneInCenterCreatePage.add(txtGenreCreatePage, 2, 3);
         topGridPaneInCenterCreatePage.add(lblRatingCreatePage, 1, 4);
         topGridPaneInCenterCreatePage.add(buttonsBoxCreatePage, 2, 4);
         topGridPaneInCenterCreatePage.add(lblDescriptionCreatePage, 1, 5);

         centerPaneCreatePage.setTop(topGridPaneInCenterCreatePage);

         centerPaneCreatePage.setCenter(txtDescriptionCreatePage);

         bottomPaneCreatePage.add(btnCancelCreatePage, 1, 1);
         bottomPaneCreatePage.add(btnSaveCreatePage, 2, 1);
         bottomPaneCreatePage.setHgap(50);
         bottomPaneCreatePage.setVgap(5);
         bottomPaneCreatePage.setAlignment(Pos.BOTTOM_RIGHT);

 	    rootCreatePage.setTop(topPaneCreatePage);
 	    rootCreatePage.setCenter(centerPaneCreatePage);
 	    rootCreatePage.setBottom(bottomPaneCreatePage);

 	    Scene sceneCreatePage = new Scene(rootCreatePage, 500, 370);

 	    sceneCreatePage.getStylesheets().add(stylesheet);



        // Search Page (main page) Event Handlers

 	    // event listener for search button
 	    // When you search, it will use the string in the search bar
 	    // as a search key to search through the comics array list.
        btnSearch.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

           	 String searchKey = searchBar.getText();
           	 itNext = Records.searchComic(comics, searchKey).listIterator();

           	 int theRating=0;
           	 recordCounter = 1;

           	 ComicBook cb = new ComicBook("hello", 1, "Joe", "joe", "joe");

           	 if(itNext.hasNext()){
           		 cb=(ComicBook)itNext.next();
                    theString = cb.getTitle();
                    theStringAuthor = cb.getAuthor();
                    globalGenre = cb.getGenre();
                    globalDescription = cb.getDescription();
                    theRating = cb.getRating();

           	 }else{
           		 Alert emptySearch = new Alert(AlertType.INFORMATION);
           		 emptySearch.setHeaderText("Empty string alert");
           		 String message = "Sorry. No records found with this search key. :(";
           		 emptySearch.setContentText(message);
           		 emptySearch.show();
           	 }


           	    txtTitle.setText(theString);
                txtAuthor.setText(theStringAuthor);
                txtGenre.setText(globalGenre);
                txtAreaDescription.setText(globalDescription);
                txtRating.setText(Integer.toString(theRating));

                txtTitleEditPage.setText(theString);
                txtAuthorEditPage.setText(theStringAuthor);
                txtGenreEditPage.setText(globalGenre);
                txtDescriptionEditPage.setText(globalDescription);


                searchBar.setText("");

            }
       });


        // Event listener to for next button.
        // When you click it, it will go to the next comic.
        btnNextRecord.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

               // ListIterator<ComicBook> itNext = comics.listIterator();

        	   int theRating=0;
               ComicBook cb = new ComicBook("hello", 1, "Joe Bob");


                if(itNext.hasNext()){
                    cb=(ComicBook)itNext.next();
                    theString = cb.getTitle();
                    theStringAuthor = cb.getAuthor();
                    globalGenre = cb.getGenre();
                    globalDescription = cb.getDescription();
                    theRating = cb.getRating();
            }

              	 txtTitle.setText(theString);
                 txtAuthor.setText(theStringAuthor);
                 txtGenre.setText(globalGenre);
                 txtAreaDescription.setText(globalDescription);
                 txtRating.setText(Integer.toString(theRating));

                 txtTitleEditPage.setText(theString);
                 txtAuthorEditPage.setText(theStringAuthor);
                 txtGenreEditPage.setText(globalGenre);
                 txtDescriptionEditPage.setText(globalDescription);

                 recordCounter = 2;


           }
       });

        btnNextRecord.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        btnNextRecord.setEffect(blend);
                    }
        });

        btnNextRecord.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        btnNextRecord.setEffect(null);
                    }
            });


        // Event listener to for previous button.
        // When you click it, it will go to the previous comic.
        btnPreviousRecord.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

            	int theRating=0;
                ComicBook cb = new ComicBook("hello", 1,"some author");

                 if(itNext.hasPrevious()){
                     cb=(ComicBook)itNext.previous();
                     theString = cb.getTitle();
                     theStringAuthor = cb.getAuthor();
                     globalGenre = cb.getGenre();
                     globalDescription = cb.getDescription();
                     theRating = cb.getRating();

             }

              txtTitle.setText(theString);
              txtAuthor.setText(theStringAuthor);
              txtGenre.setText(globalGenre);
              txtAreaDescription.setText(globalDescription);
              txtRating.setText(Integer.toString(theRating));
              recordCounter=1;

              txtTitleEditPage.setText(theString);
              txtAuthorEditPage.setText(theStringAuthor);
              txtGenreEditPage.setText(globalGenre);
              txtDescriptionEditPage.setText(globalDescription);
            }
        });

        btnPreviousRecord.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        btnPreviousRecord.setEffect(blend);
                    }
        });

        btnPreviousRecord.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        btnPreviousRecord.setEffect(null);
                    }
            });


        // Event listener to for last record button.
        // When you click it, it will go to the last comic.
       btnLastRecord.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

        	   int theRating=0;
               ComicBook cb = new ComicBook("hello", 1, "Robert");

               while(itNext.hasNext()){
                   cb=itNext.next();
                   theString = cb.getTitle();
                   theStringAuthor = cb.getAuthor();
                   globalGenre = cb.getGenre();
                   globalDescription = cb.getDescription();
                   theRating = cb.getRating();
               }


               txtTitle.setText(theString);
               txtAuthor.setText(theStringAuthor);
               txtGenre.setText(globalGenre);
               txtAreaDescription.setText(globalDescription);
               txtRating.setText(Integer.toString(theRating));
               recordCounter=2;

               txtTitleEditPage.setText(theString);
               txtAuthorEditPage.setText(theStringAuthor);
               txtGenreEditPage.setText(globalGenre);
               txtDescriptionEditPage.setText(globalDescription);



           }
       });

       btnLastRecord.addEventHandler(MouseEvent.MOUSE_ENTERED,
               new EventHandler<MouseEvent>() {
                   @Override public void handle(MouseEvent e) {
                       btnLastRecord.setEffect(blend);
                   }
       });

       btnLastRecord.addEventHandler(MouseEvent.MOUSE_EXITED,
               new EventHandler<MouseEvent>() {
                   @Override public void handle(MouseEvent e) {
                       btnLastRecord.setEffect(null);
                   }
           });

       // Event listener to for first record button.
       // When you click it, it will go to the first comic.
       btnFirstRecord.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

        	   int theRating=0;
               ComicBook cb = new ComicBook("hello", 1,"some author");

               while(itNext.hasPrevious()){
                   cb=(ComicBook)itNext.previous();
                   theString = cb.getTitle();
                   theStringAuthor = cb.getAuthor();
                   globalGenre = cb.getGenre();
                   globalDescription = cb.getDescription();
                   theRating = cb.getRating();

           }

            txtTitle.setText(theString);
            txtAuthor.setText(theStringAuthor);
            recordCounter=1;
            txtGenre.setText(globalGenre);
            txtAreaDescription.setText(globalDescription);
            txtRating.setText(Integer.toString(theRating));

            txtTitleEditPage.setText(theString);
            txtAuthorEditPage.setText(theStringAuthor);
            txtGenreEditPage.setText(globalGenre);
            txtDescriptionEditPage.setText(globalDescription);
           }
       });

       btnFirstRecord.addEventHandler(MouseEvent.MOUSE_ENTERED,
               new EventHandler<MouseEvent>() {
                   @Override public void handle(MouseEvent e) {
                       btnFirstRecord.setEffect(blend);
                   }
       });

       btnFirstRecord.addEventHandler(MouseEvent.MOUSE_EXITED,
               new EventHandler<MouseEvent>() {
                   @Override public void handle(MouseEvent e) {
                       btnFirstRecord.setEffect(null);
                   }
           });


       // Event listener to for new comic button.
       // When you click it, it will go to the new comic gui.
       btnNewComic.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

           	primaryStage.setScene(sceneCreatePage);
           	primaryStage.show();
           }
       });

       // Event listener to for edit comic button.
       // When you click it, it will go to the edit comic gui.
       btnEdit.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

           	primaryStage.setScene(sceneEditPage);
           	primaryStage.show();

           	txtTitleEditPage.setText(theString);
            txtAuthorEditPage.setText(theStringAuthor);


           }
       });



       // Edit Page Event Handler

       // set radio button handlers in the edit page.
       // When you click the radio buttons in the eidt page,
       // it will dynamically change the rating value to the
       // corresponding rating (1, 2, 3, 4, or 5).
       RadioRatingEditPageHandler rrs = new RadioRatingEditPageHandler();
       opt1EditPage.setOnAction(rrs);
       opt2EditPage.setOnAction(rrs);
       opt3EditPage.setOnAction(rrs);
       opt4EditPage.setOnAction(rrs);
       opt5EditPage.setOnAction(rrs);

       // Event listener to for back button in the edit page GUI.
       // When you click it, it will go back to the search comic GUI.
       btnEdit.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

          	 primaryStage.setScene(sceneEditPage);

           }
       });

       // Event listener to for back button in the edit page GUI.
       // When you click it, it will go back to the search comic GUI.
       btnBackEditPage.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

          	 primaryStage.setScene(sceneMain);

           }
       });

       // Event listener to for save button in the edit page GUI.
       // When you click it, it will edit the current comic.
       btnSaveEditPage.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

        	   System.out.println("asdfasdfasd");

        		 String searchKey = searchBar.getText();
               	 itNext = Records.searchComic(comics, searchKey).listIterator();


               	 ComicBook cb = new ComicBook("ksksksksks", 1, "Joe", "bob", "henry");
               	 itNext.add(cb);

               	 if(itNext.hasNext()){

               		 if(recordCounter == 1){
               		 cb=(ComicBook)itNext.next();
               		 }
               		 else if (recordCounter==2){
               			 cb=(ComicBook)itNext.previous();
               		 }




               		 theString = txtTitleEditPage.getText();
                        cb.setTitle(theString);
                        theStringGenre = txtGenreEditPage.getText();
                        cb.setGenre(theStringGenre);
                        theStringAuthor = cb.getAuthor();

                        theStringDescription = txtDescriptionEditPage.getText();
                        cb.setDescription(theStringDescription);


                        comics.remove(cb);
                        Records.addComic(comics, txtTitleEditPage.getText(), txtAuthorEditPage.getText(), globalRating,
                        		txtGenreEditPage.getText(), txtDescriptionEditPage.getText());

                        itNext = comics.listIterator();

                        primaryStage.setScene(sceneMain);


                        txtTitle.setText("");
                     	 txtAuthor.setText("");
                     	 txtGenre.setText("");
                     	 txtRating.setText("");
                     	 txtAreaDescription.setText("");

                        Alert  comicDeleted = new Alert(AlertType.INFORMATION);
                        comicDeleted.setHeaderText("Comicbook Edited");
                  		 String Deletemessage = "The comic has beeen edited and saved.";
                  		comicDeleted.setContentText(Deletemessage);
                  		comicDeleted.show();


               	 }

                }
           });

       // Event listener to for delete button in the edit page GUI.
       // When you click it, it will delete the comic.
       btnDeleteEditPage.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){

        	     Alert deleteConfirmation = new Alert(AlertType.CONFIRMATION);
        	     deleteConfirmation.setHeaderText("Delete Confirmation ");
         		 String deleteMessage = "Are you sure you would like to delete this comic";
         		 deleteConfirmation.setContentText(deleteMessage);

         		 Optional<ButtonType> result = deleteConfirmation.showAndWait();

         		 if(result.get() == ButtonType.OK){

         			 ComicBook cb = new ComicBook("Comic", 1, "Joe");

         			 if(itNext.hasPrevious()){

         				if(recordCounter == 1){
                      		 cb=(ComicBook)itNext.next();
                      		 }
                      		 else {
                      			 cb=(ComicBook)itNext.previous();
                      		 }

         				 theString = txtTitleEditPage.getText();
         				 cb.setTitle(theString);
         				 theStringAuthor = cb.getAuthor();

         				 comics.remove(cb);

         				 itNext = comics.listIterator();

                        Alert  comicDeleted = new Alert(AlertType.INFORMATION);
                        comicDeleted.setHeaderText("Comicbook Deleted");
                  		 String Deletemessage = "The comic has beeen deleted";
                  		comicDeleted.setContentText(Deletemessage);
                  		comicDeleted.show();


                  		txtTitleEditPage.setText("  ");
                  		txtAuthorEditPage.setText("  ");
                  		txtDescriptionEditPage.setText("  ");
                  		txtGenreEditPage.setText("  ");


                  		txtTitle.setText("  ");
                  		txtAuthor.setText("  ");
                  		txtAreaDescription.setText("  ");
                  		txtGenre.setText("  ");
               	 }
         		 }

                }
           });



 	   // Create Page Event Handlers

       // set handlers for radio button in the create page
       RadioRatingCreatePageHandler rcs = new RadioRatingCreatePageHandler();
       optOneCreatePage.setOnAction(rcs);
       optTwoCreatePage.setOnAction(rcs);
       optThreeCreatePage.setOnAction(rcs);
       optFourCreatePage.setOnAction(rcs);
       optFiveCreatePage.setOnAction(rcs);

       // Event listener to for save button in the create page GUI.
       // When you click it, it will save a new comic into the list.
        btnSaveCreatePage.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

                	 try{

            			// fix the rating part of the add comic
                         Records.addComic(comics, txtTitleCreatePage.getText(), txtAuthorCreatePage.getText(), globalRating,
                         		txtGenreCreatePage.getText(), txtDescriptionCreatePage.getText());

                         itNext = comics.listIterator();

                         primaryStage.setScene(sceneMain);

                         Alert  comicSaved = new Alert(AlertType.INFORMATION);
                         comicSaved.setHeaderText("Comicbook Saved");
                   		 String comicSavedMessage = "The comic has been saved.";
                   		comicSaved.setContentText(comicSavedMessage);
                   		comicSaved.show();

                	 }catch(Exception e){
                		 Alert  comicNotSaved = new Alert(AlertType.INFORMATION);
                         comicNotSaved.setHeaderText("Comicbook NotSaved");
                   		 String notSavedMessage = "Sorry. The comic was not saved.";
                   		comicNotSaved.setContentText(notSavedMessage);
                   		comicNotSaved.show();
                	 }


                 }
            });

        // Event listener to for cancel button in the create page GUI.
        // When you click it, it will go back to the search comic GUI.
        btnCancelCreatePage.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

           	 primaryStage.setScene(sceneMain);

            }
        });

     }



     public static void main(String[] args) {
         launch(args);
     }

     // radio handler for edit page
     private class RadioRatingEditPageHandler implements EventHandler<ActionEvent>{

         @Override
         public void handle(ActionEvent event){

             if(opt1EditPage.isSelected()){

            	 globalRating = 1;

             }

             else if(opt2EditPage.isSelected()){
            	 globalRating = 2;
             }
             else if(opt3EditPage.isSelected()){


            	 globalRating = 3;
             }
             else if(opt4EditPage.isSelected()){


            	 globalRating = 4;
          }
             else if(opt5EditPage.isSelected()){

            	 globalRating = 5;

             }

         }
     }

     // radio handler for create page
     private class RadioRatingCreatePageHandler implements EventHandler<ActionEvent>{

         @Override
         public void handle(ActionEvent event){

             if(optOneCreatePage.isSelected()){

            	 	globalRating = 1;

             }

             else if(optTwoCreatePage.isSelected()){
            	 globalRating = 2;
             }
             else if(optThreeCreatePage.isSelected()){


            	 globalRating = 3;
             }
             else if(optFourCreatePage.isSelected()){

            	 globalRating = 4;
          }
             else if(optFiveCreatePage.isSelected()){

            	 globalRating = 5;

             }

         }

     }


 }
