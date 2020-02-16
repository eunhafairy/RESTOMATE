
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
public class HomeController implements Initializable {

    public void backtoLogin(ActionEvent event) throws IOException{
        
        Parent homePage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
   Scene scene_homePage = new Scene(homePage);
   
   Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
   
   window.setScene(scene_homePage);
   window.show();
        
    
    }
    public void gotoTable(ActionEvent event) throws IOException{
        
   Parent editPage = FXMLLoader.load(getClass().getResource("EditPage.fxml"));
   Scene scene_editPage = new Scene(editPage);
   
   Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
   
   window1.setScene(scene_editPage);
   window1.show();
        
    
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
