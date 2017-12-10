	import java.io.File;
	import java.util.ArrayList;

	import javafx.application.Application;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
	import javafx.scene.layout.BorderPane;

public class Driver {
		
		public static void main(String[] args) throws Exception {
			
			TreeThing q=new TreeThing();
			
			File file =new File("Country.txt");
			
			ArrayList<Countries> r=q.load(file);
			q.update(r);

			//System.out.println(w.search("4").toString());
						
		}
	}

