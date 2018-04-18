package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;


public class Main extends Application {
	static Parent root;
	static nextScene scene;
	static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		root= FXMLLoader.load(getClass().getResource("login.fxml"));
        scene = new nextScene(root);
        stage = primaryStage;
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


class nextScene extends Scene{

	public nextScene(Parent arg0) {
		super(arg0);

	}

	 public void change(String x) throws IOException{
		 Main.root= FXMLLoader.load(getClass().getResource(x+".fxml"));
	     Main.scene = new nextScene(Main.root);
	     Main.stage.setScene(Main.scene);
	     Main.stage.show();
	 }


	 public void openDialog(String x) throws IOException{
		 final Stage dialog = new Stage();
	        dialog.initModality(Modality.APPLICATION_MODAL);
	        dialog.initOwner(Main.stage);
	        Parent root= FXMLLoader.load(getClass().getResource(x+".fxml"));
	        nextScene scene = new nextScene(root);
	      /*  Stage stage = Main.stage;*/
	        dialog.setScene(scene);
	        dialog.show();

	 }

}
