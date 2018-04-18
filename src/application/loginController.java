package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
		//TODO: check if user exists in table
		// currently just logs in without checking if user exists. 
		errorLabel.setVisible(false);
		Main.scene.change("dash");
		
		/*
		 * IF user does not exist:
		 * errorLabel.setVisible(true);
		 * errorLabel.setText("User does not exist");
		 * 
		 * if user exists but invalid password:
		 * errorLabel.setVisible(true);
		 * errorLabel.setText("Wrong Password")
		 */
	}
	
}
