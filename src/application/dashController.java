package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class dashController {
	public Button logoutBtn, resetPwd;
	
	@FXML
	public void initialize() {
		
		
		logoutBtn.setOnAction(arg0 -> {
			try {
				handleLogoutAction(arg0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		resetPwd.setOnAction(arg0 -> {
			try {
				handleResetAction(arg0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	private void handleResetAction(ActionEvent arg0) throws IOException {
		// TODO make changes in 
		
		Main.scene.openDialog("change_pwd");
		
	}

	private void handleLogoutAction(ActionEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		
		Main.scene.change("login");
	}

}
