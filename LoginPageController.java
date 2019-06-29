package application;

import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {
	
	@FXML TextField userName;
	@FXML PasswordField Pass;
	CConnection con=new CConnection();

	public void LoginButtonClicked(ActionEvent ev) {
		try {
			Statement stmt=con.createConnection();
			String sqlQuery="Select * from employee WHERE userName='"+userName.getText()+"' AND Pass ='"+Pass.getText().toString()+"'";
			ResultSet rs=stmt.executeQuery(sqlQuery);
			if(rs.next()) {
				Parent parent=FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
				Scene Dashboard=new Scene(parent);
				Stage dashBoardStage=(Stage)((Node)ev.getSource()).getScene().getWindow();
				dashBoardStage.setScene(Dashboard);
				dashBoardStage.setTitle("Dashboard");
				
			}
			else {
				System.out.println("Login failed"); 
			}
		}
		catch(Exception e) { 
			System.out.println("Error in SQL");
			e.printStackTrace();
		}
		
		
		
		/*System.out.println(userName.getText());
		System.out.println(Pass.getText().toString());*/
	}
	public void ClearButtonClicked() {
		userName.clear();
		Pass.clear();
	}
}
