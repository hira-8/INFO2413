package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class OrderFormController {

@FXML
private TextField order_ID;

@FXML
private TextField lName;

@FXML
private TextField P_Code;

@FXML
private TextArea comments;

@FXML
private TextField color;

@FXML
private TextArea accessories;

@FXML
private TextField City;

@FXML
private TextField client_ID;

@FXML
private TextField eqp_ID;

@FXML
private DatePicker date_in;

@FXML
private TextField fName;

@FXML
private TextField St_No;

@FXML
private TextField model;

@FXML
private TextField company;

@FXML
private DatePicker date_out;

@FXML
private TextField serial_no;

@FXML
private TextField email;

@FXML
private TextField ph_1;

@FXML
private TextField ph_2;

@FXML
private TextField ave;


@FXML
public void submitBtnClicked() {
	// To add client & Equipment information into PHPAdmin ----------------------------------------------------------------------------------------------------
	try{
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_repair_shop","root","");
	Statement stmt=connection.createStatement();
	String sqlQuery = "insert into cclient (order_ID, client_ID, fName, lName, email, ph_1, ph_2, St_No, ave, P_Code, City, date_in, date_out)"
			+ " VALUES ('"+order_ID.getText()+"', '"+client_ID.getText()+"','"+fName.getText()+"','"+lName.getText()+"','"+email.getText()+"','"+ph_1.getText()+"',"
					+ "'"+ph_2.getText()+"','"+St_No.getText()+"','"+ave.getText()+"','"+P_Code.getText()+"','"+City.getText()+"',"
							+ "'"+(date_in.getValue()!=null? date_in.getValue().toString():"")+"','"+(date_out.getValue()!=null? date_out.getValue().toString():"")+"');";
	int rs= stmt.executeUpdate(sqlQuery);

	if(rs ==1) {
		System.out.println("Successfull");
		}
	else {
		System.out.println("Failed");
	}
	
	String sqlQueryEqp = "insert into equipment (eqp_ID, serial_no, model , comments, company , color, accessories)"
			+ " VALUES ('"+eqp_ID.getText()+"', '"+serial_no.getText()+"','"+model.getText()+"','"+comments.getText()+"','"+company.getText()+"','"+color.getText()+"',"
					+ "'"+accessories.getText()+"');";
	int rs1= stmt.executeUpdate(sqlQueryEqp);

	if(rs1 ==1) {
		System.out.println("Successfull");
		}
	else {
		System.out.println("Failed");
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	// End of Client Info into PHPAdmin ------------------------------------------------------------------------------------------------------------
 }

public void clearBtnClicked() {
	order_ID.clear();
	client_ID.clear();
	fName.clear();
	lName.clear();
	email.clear();
	ph_1.clear();
	ph_2.clear();
	St_No.clear();
	ave.clear();
	P_Code.clear();
	City.clear();
	date_in.getEditor().clear();
	date_out.getEditor().clear();
	eqp_ID.clear();
	serial_no.clear();
	model.clear();
	comments.clear();
	company.clear();
	color.clear();
	accessories.clear();
	
	
}

public void backBtnClicked(ActionEvent ev) {
	try {
	Parent parent=FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
	Scene Dashboard=new Scene(parent);
	Stage dashBoardStage=(Stage)((Node)ev.getSource()).getScene().getWindow();
	dashBoardStage.setScene(Dashboard);
	dashBoardStage.setTitle("Dashboard");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
 }

