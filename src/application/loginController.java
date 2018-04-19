package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;

public class loginController {
	public Label errorLabel;
	public Button loginBtn;
	public TextField emailID;
	public PasswordField pwd;
	
	@FXML
	public void initialize() {
		errorLabel.setVisible(false);
		loginBtn.setOnAction(arg0 -> {
			try {
				handleLoginAction(arg0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	private void handleLoginAction(ActionEvent arg0) throws IOException {
		try {
			errorLabel.setVisible(false);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gym?autoReconnect=true&useSSL=false","root", "root");
			Statement statement = connect.createStatement();
			int found=0;
			String s_id="";
			String query = "select * from staff;";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("email");
				if(id.equals(emailID.getText())) {
					found=1;
					s_id=rs.getString("s_id");
					break;
				}
			}
			
			if(found==1) {
				statement = connect.createStatement();
				query = "select * from admin;";
				rs = statement.executeQuery(query);
				while(rs.next()) {
					if (rs.getString("s_id").equals(s_id)){
						if(rs.getString("password").equals(pwd.getText())){
							Main.scene.change("dash");
						}
						else {
							errorLabel.setVisible(true);
							errorLabel.setText("Wrong password");
						}
					}
				}
			}
			else {
				errorLabel.setVisible(true);
				errorLabel.setText("Invalid email id");
			}
			
		}
		catch (Exception e){
			System.out.println("fuck");
			e.printStackTrace();
		}
	}
	
}
