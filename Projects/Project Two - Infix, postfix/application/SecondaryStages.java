package application;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SecondaryStages {
	
	static Scene scene;
	static Stage ss = new Stage();
	static Calculations c = new Calculations(20);
	
	static ListView<String> infix = new ListView<String>();
	static ListView<String> validation = new ListView<String>();
	static ListView<String> postFix = new ListView<String>();
	static ListView<String> result = new ListView<String>();
	
	
	public static void getWriteStage(){
		
		BorderPane root= new BorderPane();
		GridPane writeGP = new GridPane();
		
		TextField writeTf = new TextField(null);
		
		Button calculateBt = new Button("Calculate");
		calculateBt.setPrefWidth(100);		
		calculateBt.setOnAction(e -> { 
				if (writeTf.getText() == null)
				Alert("You didn't add an equation ! Please try again");
			else if(!isnumbers(writeTf.getText()))
				Alert("You add a letter on equation");
			else{
				try {
					Calculations.write(writeTf.getText());
					ss.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}		
		});
		Button cancelBt = new Button("Cancel");
		cancelBt.setOnAction(e -> {
				ss.close();
		});	
		HBox buttons = new HBox(7);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(calculateBt, cancelBt);
		
		root.setCenter(writeTf);
		root.setBottom(buttons);
		ss.setTitle("Write an equation");
		Scene scene2 = new Scene(root,350,100);
		ss.setScene(scene2);
		ss.show();	
	}
	
	public static void getDisplayStage(){
		BorderPane root= new BorderPane();
		GridPane saleGP = new GridPane();
		
		Label l1 = new Label("\tEquation ( Infix )");
		Label l2 = new Label("Validation");
		Label l3 = new Label("PostFix");
		Label l4 = new Label("\tResult");
		l1.setFont(new Font("Arial",20));
		l2.setFont(new Font("Arial",20));
		l3.setFont(new Font("Arial",20));
		l4.setFont(new Font("Arial",20));

		getInfix();
		getValidation();
		getPostFix();
		getResult();
		HBox labels = new HBox(150);
		labels.getChildren().addAll(l1,l2,l3,l4);
		root.setTop(labels);
		HBox hb = new HBox(3);
		hb.getChildren().addAll(infix,validation,postFix,result);
		root.setCenter(hb);
		
		ss.setTitle("Display");
		Scene scene2 = new Scene(root,1020,700);
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
	
	public static void getInfix(){
//		infix.setMaxSize(600, 2000);
		infix.getItems().clear();
		int count=0;
		while(count<c.infixL.size()){
			infix.getItems().add(c.infixL.get(count));
			count++;
		}
	}
	
	public static void getValidation(){

		validation.getItems().clear();
		int count=0;
		while(count<c.infixL.size()){
			if(c.isValid(c.infixL.get(count)))
				validation.getItems().add("True");
			else
			validation.getItems().add("False");
			count++;
		}
	}
	
	public static void getPostFix(){

		postFix.getItems().clear();
		int count=0;
		while(count<c.postL.size()){
			postFix.getItems().add(c.postL.get(count));
			count++;
		}
	}
	
	public static boolean isnumbers(String x){
		if(x.contains("0")||x.contains("1")||x.contains("2")||x.contains("3")||x.contains("4")||x.contains("5")||x.contains("6")||x.contains("7")||x.contains("8")||x.contains("9")||x.contains("+")||x.contains("-")||x.contains("*")||x.contains("/")||x.contains(")")||x.contains("("))
			return true;
	return false;}
	
	public static void getResult(){

		result.getItems().clear();
		int count=0;
		while(count<c.resultL.size()){
			result.getItems().add(c.resultL.get(count));
			count++;
		}
	}
}
