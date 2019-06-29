package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		Parent parent=FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene LoginScene=new Scene(parent);
		primaryStage.setTitle("Login Page");
		primaryStage.setScene(LoginScene);
		primaryStage.show();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
