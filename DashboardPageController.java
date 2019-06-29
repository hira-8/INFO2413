package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardPageController {
	CConnection conn = new CConnection();
	
	public void OrderFormBtnClicked(ActionEvent ev) {
		try {
			Parent parent =FXMLLoader.load(getClass().getResource("Order_Form.fxml"));
			Scene orderForm = new Scene(parent);
			Stage dashBoardStage =(Stage)((Node)ev.getSource()).getScene().getWindow();
			dashBoardStage.setScene(orderForm);
			dashBoardStage.setTitle(" Order Form");
		}
		catch(Exception e){
			e.printStackTrace();;
			
		}
		
	}
		public void orderListBtnClicked(ActionEvent ev) {
			try {
				Parent parent =FXMLLoader.load(getClass().getResource("orderList.fxml"));
				Scene orderList = new Scene(parent);
				Stage dashBoardStage =(Stage)((Node)ev.getSource()).getScene().getWindow();
				dashBoardStage.setScene(orderList);
				dashBoardStage.setTitle(" SkyNet Orders List");
			}
			catch(Exception e){
				e.printStackTrace();
				
			}}	
		public void inventoryBtnClicked(ActionEvent ev) {
			try {
				Parent parent =FXMLLoader.load(getClass().getResource("Inventory.fxml"));
				Scene inventoryList = new Scene(parent);
				Stage dashBoardStage =(Stage)((Node)ev.getSource()).getScene().getWindow();
				dashBoardStage.setScene(inventoryList);
				dashBoardStage.setTitle(" SkyNet Inventory List");
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
	}
		public void TasksBtnClicked(ActionEvent ev) {
			try {
				Parent parent =FXMLLoader.load(getClass().getResource("Tasks.fxml"));
				Scene tasksList = new Scene(parent);
				Stage dashBoardStage =(Stage)((Node)ev.getSource()).getScene().getWindow();
				dashBoardStage.setScene(tasksList);
				dashBoardStage.setTitle(" SkyNet Tasks List");
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
	}
		
		public void backBtnClicked(ActionEvent ev) {
			try {
			Parent parent=FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene LoginScene=new Scene(parent);
			Stage dashBoardStage=(Stage)((Node)ev.getSource()).getScene().getWindow();
			dashBoardStage.setScene(LoginScene);
			dashBoardStage.setTitle("Login Page");
		}
			catch(Exception e) {
				e.printStackTrace();
			}
}
		}