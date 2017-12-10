package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;


public class Main extends Application {
	
	static Library storage = new Library();
	static BorderPane root = new BorderPane();
	static Scene scene = new Scene(root,1000,600);
	static Stage stage1;
	static TableView<Book> table = new TableView<Book>();
	final static ObservableList<Book> data= FXCollections.observableArrayList(new Book("as", "as", "f", "gf", 100, 1));
	
	static ListView<String> list=new ListView<>();
	
	@Override
 	public void start(Stage primaryStage) {
		stage1=primaryStage;
		scene=showFirstStage();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	
	public static void main(String[] args) throws Exception {
		launch(args);
//		System.out.println(storage.toString());
	}

	public static Scene showFirstStage(){
		try{
			
			final Label bookStoreL = new Label("Book Store");
			bookStoreL.setFont(new Font("Arial",20));
			
			VBox lvBox = new VBox();
			lvBox.setPrefWidth(200);
			
			
			
			table.setEditable(true);
			
			TableColumn authorCol = new TableColumn("Author");
			authorCol.setCellValueFactory(
					new PropertyValueFactory<Book, String>("Author"));
			
			TableColumn titleCol = new TableColumn("Title");
			titleCol.setCellValueFactory(
					new PropertyValueFactory<Book, String>("Title"));
			
			TableColumn editionCol = new TableColumn("Edition");
			editionCol.setCellValueFactory(
					new PropertyValueFactory<Book, String>("Edition"));
			
			TableColumn publisherCol = new TableColumn("Publisher");
			publisherCol.setCellValueFactory(
					new PropertyValueFactory<Book, String>("Publisher"));
			
			TableColumn priceCol = new TableColumn("Price");
			priceCol.setCellValueFactory(
					new PropertyValueFactory<Book, String>("Price"));
			
			TableColumn quantityCol = new TableColumn("Quantity");
			quantityCol.setCellValueFactory(
					new PropertyValueFactory<Book, String>("Quantity"));
			
			authorCol.setMinWidth(lvBox.getPrefWidth());
			titleCol.setMinWidth(lvBox.getPrefWidth());
			editionCol.setMinWidth(lvBox.getPrefWidth());
			publisherCol.setMinWidth(lvBox.getPrefWidth());
			priceCol.setMaxWidth(lvBox.getPrefWidth());
			quantityCol.setMaxWidth(lvBox.getPrefWidth());
			
			table.getColumns().addAll(authorCol,titleCol,editionCol,publisherCol,priceCol,quantityCol);
			final VBox tableVBox = new VBox();
			tableVBox.setSpacing(5);
			tableVBox.setPadding(new Insets(0,0,0,0));
			tableVBox.getChildren().addAll(bookStoreL,list);
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(100);
		
		Button loadBt = new Button("Load File");
		loadBt.setMinWidth(vBox.getPrefWidth());
		loadBt.setOnAction(e -> {
			try{
				FileChooser chose = new FileChooser();
				chose.setTitle("choose a file");
				File file = chose.showOpenDialog(new Stage());

					storage.load(file);

			}catch(Exception e1){
				
			}
		});

		Button displayBt = new Button("Display");
		displayBt.setMinWidth(vBox.getPrefWidth());
		displayBt.setOnAction(e-> {
			Node current = storage.getFirst();

			list.getItems().clear();//list view 
			if(current==null)
				list.getItems().add("there is no book to display in the store");

			while (current != null) {
				list.getItems().add(current.toString());
				current = current.next;
			}
			
		});

		Button reportBt = new Button("Report");
		reportBt.setMinWidth(vBox.getPrefWidth());
		reportBt.setOnAction(e -> {
			try {
				FileChooser chose = new FileChooser();
				chose.setTitle("choose a file");
				File file = chose.showOpenDialog(new Stage());
				if (file != null) {
				storage.report(file);
				SecondaryStages.Alert("Done");
				}} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Button purchaseBt = new Button("Purchase");
		purchaseBt.setMinWidth(vBox.getPrefWidth());
		purchaseBt.setOnAction(e -> {
			SecondaryStages.getPurchaseStage();
		});

		Button saleBt = new Button("Sale");
		saleBt.setMinWidth(vBox.getPrefWidth());
		saleBt.setOnAction(e -> {
			SecondaryStages.getSaleStage();	
		});

		Button searchBt = new Button("Search");
		searchBt.setMinWidth(vBox.getPrefWidth());
		searchBt.setOnAction(e -> {
			SecondaryStages.getSearchStage();
		});
		
		HBox hLine1=new HBox(340);
		HBox hLine2=new HBox(340);
		HBox hLine3=new HBox(340);
		hLine1.getChildren().addAll(loadBt,purchaseBt,searchBt);
		hLine2.getChildren().addAll(displayBt,saleBt,reportBt);
		hLine3.getChildren().add(reportBt);
		VBox vLine1 = new VBox(10);
		VBox vLine2 = new VBox(10);
		VBox vLine3 = new VBox(10);
		VBox vLine = new VBox(10);
		vLine1.getChildren().add(hLine1);
		vLine2.getChildren().addAll(hLine2);
		vLine3.getChildren().addAll(hLine3);
		vLine.getChildren().addAll(vLine1,vLine2,vLine3);
		root.setTop(vLine);

		
		root.setBottom(tableVBox);
		}
		 catch(Exception e) {
				e.printStackTrace();
			}
		return scene;
	}
}