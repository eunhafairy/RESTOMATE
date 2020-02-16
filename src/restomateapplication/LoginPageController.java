/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restomateapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author pisonet2
 */
public class LoginPageController implements Initializable {

   @FXML private TextField textBox_username;
   @FXML private PasswordField pwfield_password; 
   @FXML private Label incorrect;
  
  

       
       
  
   public void loginClicked(ActionEvent event) throws IOException{




   if(String.valueOf(this.textBox_username.getText()).equals("admin") && String.valueOf(this.pwfield_password.getText()).equals("admin")){
   
      
   Parent homePage = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
   Scene scene_homePage = new Scene(homePage);
   Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
   window.setScene(scene_homePage);
   window.show();
   
   }
   else{
   incorrect.setText("Invalid username/password");
  
   }
 }

         
   
   
  
   public void exitClicked(ActionEvent event) throws IOException{
  
   Parent homePage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
   Scene scene_homePage = new Scene(homePage);
   Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
   window.setScene(scene_homePage);
   window.close();
   
   }
   
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       incorrect.setText(" ");
    
       
    }
}    
    


