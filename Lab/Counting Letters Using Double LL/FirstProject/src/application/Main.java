package application;
	
import java.io.File;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	
	@Override
	public void start(Stage primaryStage) {
		stage1=primaryStage;
		scene=showFirstStage();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public static Scene showFirstStage(){
		try{
			
			final Label bookStoreL = new Label("Book Store");
			bookStoreL.setFont(new Font("Arial",20));
			
			VBox lvBox = new VBox();
			lvBox.setPrefWidth(200);
			
			table.setEditable(true);
			
			TableColumn authorCol = new TableColumn("Author");
			TableColumn titleCol = new TableColumn("Title");
			TableColumn editionCol = new TableColumn("Edition");
			TableColumn publisherCol = new TableColumn("Publisher");
			TableColumn priceCol = new TableColumn("Price");
			TableColumn quantityCol = new TableColumn("Quantity");
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
			tableVBox.getChildren().addAll(bookStoreL,table);
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(100);
		
		Button loadBt = new Button("Load File");
		loadBt.setMinWidth(vBox.getPrefWidth());
		/*loadBt.setOnAction(e -> {
			try{
				FileChooser choose = new FileChooser();
				choose.setTitle("Choose a file");
				File file = choose.showOpenDialog(new Stage());
				if(file !=null){
					storage.load(file);
					authorCol.setCellValueFactory(
						new PropertyValueFactory<Book, String>("Author"));
				}
				else{
					table.getItems().clear();
					table.getItems().add("the File didnt loaded properly please try again");
				}
			}catch(Exception e1){
				
			}
		});*/
		/*stage1.setOnCloseRequest(e -> {
			try {
				if (ExtraWindow.closeAlert())
					store.update();
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}
		});*/
		Button displayBt = new Button("Display");
		displayBt.setMinWidth(vBox.getPrefWidth());

		Button reportBt = new Button("Report");
		reportBt.setMinWidth(vBox.getPrefWidth());

		Button purchaseBt = new Button("Purchase");
		purchaseBt.setMinWidth(vBox.getPrefWidth());
		purchaseBt.setOnAction(e -> {
			SecondaryStages.getPurchaseStage();
		});

		Button saleBt = new Button("Sale");
		saleBt.setMinWidth(vBox.getPrefWidth());

		Button searchBt = new Button("Search");
		searchBt.setMinWidth(vBox.getPrefWidth());
		
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