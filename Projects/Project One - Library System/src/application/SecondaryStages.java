package application;



import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SecondaryStages {
	
	static Scene scene;
	static Stage ss = new Stage();
	static String path;
	private static boolean flag=false;
	
	public static void getPurchaseStage(){
		
		BorderPane root = new BorderPane();
		
		Label authorL = new Label("Author");
		TextField authorTf = new TextField(null);
		
		Label titleL = new Label("Title");
		TextField titleTf = new TextField(null);
		
		Label editionL = new Label("Edition");
		TextField editionTf = new TextField(null);
		
		Label publisherL = new Label("Publisher");
		TextField publisherTf = new TextField(null);
		
		Label priceL = new Label("Price");
		TextField priceTf = new TextField(null);
		
		Label quantityL = new Label("Quantity");
		TextField quantityTf = new TextField(null);
		
		GridPane all = new GridPane();

		Button addBt = new Button("Add");
		addBt.setPrefWidth(100);
		
		addBt.setOnAction(e -> { 
			if (authorTf.getText() == null || titleTf.getText() == null || editionTf.getText() == null || publisherTf.getText() == null
					|| priceTf.getText() == null || quantityTf.getText() == null)
				Alert("There is an empty field, write on it");
			else {
				try {
					double x = Integer.parseInt(quantityTf.getText().trim());
					if (Integer.parseInt(quantityTf.getText().trim()) > 0) {
						Library.purchase(authorTf.getText(), titleTf.getText(), editionTf.getText(), publisherTf.getText(),
								Double.parseDouble(priceTf.getText().trim()), (int) x);
						Alert("Your book is added");
						ss.close();
						
					}
				} catch (NumberFormatException e1) {
					 Alert("Please Enter a decimal numbers for price and quality");
				}
			}
		});
		
		Button cancelBt = new Button("Cancel");
		cancelBt.setPrefWidth(100);
		cancelBt.setOnAction(e -> {

			try {
				// window.setScene(scene1);
				// ExtraWindow.setScene(scene1);
				ss.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		HBox buttons = new HBox(7);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(addBt, cancelBt);
		
		all.addRow(0, authorL,authorTf);
		all.addRow(1, titleL,titleTf);
		all.addRow(2, editionL,editionTf);
		all.addRow(3, publisherL,publisherTf);
		all.addRow(4, priceL,priceTf);
		all.addRow(5, quantityL,quantityTf);
//		all.addColumn(0, authorL, titleL, editionL, publisherL, priceL, priceL);
//		all.addColumn(1, authorTf, titleTf, editionTf, publisherTf, priceTf, priceTf);
		all.setAlignment(Pos.TOP_CENTER);

		root.setCenter(all);
		root.setBottom(buttons);
		ss.setTitle("Purchse");
		Scene scene2 = new Scene(root, 400, 300);
		ss.setScene(scene2);
		ss.show();
	}
	
	public static void getSaleStage(){
		BorderPane root= new BorderPane();
		GridPane saleGP = new GridPane();
		
		Label titleL = new Label("Title");
		TextField titleTf = new TextField(null);
		
		Button buyBt = new Button("Buy");
		buyBt.setPrefWidth(100);
		
		buyBt.setOnAction(e -> { 
			if (titleTf.getText() == null)
				Alert("There is no title, please write title");
			else {
				try {
					boolean n;
						n=Library.sale(titleTf.getText());
						if(n == true){
						Alert("Done");
						ss.close();	
						}
						else{
							Alert("This book does not exist");
							ss.close();
						}
					}
				catch (NumberFormatException e1) {	
	
				}
			}
		});
		Button cancelBt = new Button("Cancel");
		cancelBt.setOnAction(e -> {
				ss.close();
		});	
		HBox buttons = new HBox(7);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(buyBt, cancelBt);
		
		saleGP.addRow(0, titleL,titleTf);
		saleGP.setAlignment(Pos.CENTER);
		root.setCenter(saleGP);
		root.setBottom(buttons);
		ss.setTitle("Sale");
		Scene scene2 = new Scene(root,200,100);
		ss.setScene(scene2);
		ss.show();
	}
	
	public static void getSearchStage(){
		
		BorderPane root= new BorderPane();
		GridPane saleGP = new GridPane();
		
		Label titleL = new Label("Title");
		TextField titleTf = new TextField(null);
		
		Label authorL = new Label("Author");
		TextField authorTf = new TextField(null);
		
		Button searchBt = new Button("Search");
		searchBt.setPrefWidth(100);
		
		searchBt.setOnAction(e -> { 
			if (titleTf.getText() == null && authorTf.getText()==null)
				Alert("There is no title, please write title");
			if (titleTf.getText() != null && authorTf.getText()!=null)
				Alert("Please write title OR author name only");
			else if(titleTf.getText() != null && authorTf.getText()==null){
				try {
					Library.search(titleTf.getText());
					if(Library.search(titleTf.getText()))
						Alert("ThisBook is Exist");
					else
						Alert("This book does not added to your library");
					ss.close();	
				}
			catch (NumberFormatException e1) {				
			}
			}
			else if(titleTf.getText() == null && authorTf.getText()!=null){
				try {
					Library.search(authorTf.getText());
					if(Library.search(authorTf.getText()))
						Alert("ThisBook is Exist");
					else
						Alert("This book did not added to your library");
					ss.close();	
					}
				catch (NumberFormatException e1) {				
				}
			}
		});
		Button cancelBt = new Button("Cancel");
		cancelBt.setOnAction(e -> {
				ss.close();
		});	
		HBox buttons = new HBox(7);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(searchBt, cancelBt);
		
		saleGP.addRow(0, titleL,titleTf);
		saleGP.addRow(1, authorL,authorTf);
		saleGP.setAlignment(Pos.CENTER);
		root.setCenter(saleGP);
		root.setBottom(buttons);
		ss.setTitle("Search");
		Scene scene2 = new Scene(root,300,150);
		ss.setScene(scene2);
		ss.show();
		
	}
	
	public static void Alert(String s){
		BorderPane root = new BorderPane();
		Label x = new Label(s);
		root.setCenter(x);

		Scene scene = new Scene(root, 460, 100);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
	}

	
	

}
