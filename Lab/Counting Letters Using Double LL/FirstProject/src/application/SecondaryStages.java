package application;

import java.awt.Label;
import java.awt.TextField;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
				Alert("there is an empty field write on it");
			else {
				try {
					double x = Integer.parseInt(quantityTf.getText().trim());
					if (Integer.parseInt(quantityTf.getText().trim()) > 0) {
						Library.purchase(authorTf.getText(), titleTf.getText(), editionTf.getText(), publisherTf.getText(),
								Double.parseDouble(priceTf.getText().trim()), (int) x);
						ss.close();
						Alert("the file have been added");
					}
				} catch (NumberFormatException e1) {
					Alert("your price or quantity have a character please try again \nor you put a double in quantity");
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
		
		
		all.addColumn(0, authorL, titleL, editionL, publisherL, priceL, priceL);
		all.addColumn(1, authorTf, titleTf, editionTf, publisherTf, priceTf, priceTf);
		all.setAlignment(Pos.TOP_CENTER);

		root.setCenter(all);
		root.setBottom(buttons);

		Scene scene2 = new Scene(root, 400, 300);
		ss.setScene(scene2);
		ss.show();
	}

	private static void Alert(String string) {
		System.out.println(string);
	}
	
	

}
