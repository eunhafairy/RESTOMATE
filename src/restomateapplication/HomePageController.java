/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restomateapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pisonet2
 */
public class HomePageController implements Initializable {

    public void backtoLogin(ActionEvent event) throws IOException{
        
        Parent homePage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
   Scene scene_homePage = new Scene(homePage);
   
   Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
   
   window.setScene(scene_homePage);
   window.show();
        
    
    }
    
    /*
    code for menu and order
    
    */
    
    @FXML private ListView menuList;
    @FXML private TextArea orderList;
  
    public void buttonIsPushed(){
    String textAreaString = "";
    
    ObservableList listofItems = menuList.getSelectionModel().getSelectedItems();
    
    for(Object item: listofItems){
    textAreaString +=String.format("%s%n", (String) item);
        
        
    }
    this.orderList.setText(textAreaString);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuList.getItems().addAll("Fishball", "Kikiam","Hotdog","Chichaw", "Kwek Kwek");
        menuList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
}
