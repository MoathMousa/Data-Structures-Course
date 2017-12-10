package application;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application{
	
	static BorderPane root = new BorderPane();
	static Scene scene = new Scene(root,400,400);
	static Stage stage1;


	@Override
	public void start(Stage primaryStage) throws Exception {
		stage1=primaryStage;
		scene=showFirstStage();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.out.println(Calculations.calculatePostFix("(5*2)*(4+2)"));
//		System.out.println(Calculations.calculateResult("5 2 * 4 2 + *"));
//		System.out.println(Calculations.isValid("5 + 3 )"));
//		System.out.println(Calculations.priority("-", "+"));
//		Calculations.load();
//		Calculations.report();
		launch(args);
	}
	
	public static Scene showFirstStage(){
		try{
			final Label calculatorL = new Label(" Calculator ");
			calculatorL.setFont(new Font("Arial",20));
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(300);
		
		Button loadBt = new Button("Load from the File");
		loadBt.setMinWidth(vBox.getPrefWidth());
		loadBt.setOnAction(e ->{
			try {
				FileChooser chose = new FileChooser();
				chose.setTitle("choose a file");
				File file = chose.showOpenDialog(new Stage());
				if (file != null) {
				Calculations.load(file);
			} }catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});


		Button writeBt = new Button("Write an equation");
		writeBt.setMinWidth(vBox.getPrefWidth());
		writeBt.setOnAction(e -> {
			SecondaryStages.getWriteStage();
		});
		

		Button displayBt = new Button("Display Invalid and Valid Equations");
		displayBt.setMinWidth(vBox.getPrefWidth());
		displayBt.setOnAction(e -> {
			try {
				SecondaryStages.getDisplayStage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Button reportBt = new Button("Report on a File");
		reportBt.setMinWidth(vBox.getPrefWidth());
		reportBt.setOnAction(e -> {
			try {
				Calculations.report();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Button exitBt = new Button("Exit");
		exitBt.setMinWidth(vBox.getPrefWidth());
		exitBt.setOnAction(e -> {
			stage1.close();
		});
		
		VBox vLine = new VBox(20);
		vLine.getChildren().addAll(calculatorL,loadBt,writeBt,displayBt,reportBt,exitBt);
		vLine.setAlignment(Pos.CENTER);
		root.setCenter(vLine);
		}
		 catch(Exception e) {
				e.printStackTrace();
			}
		return scene;
	}
}