
package restomateapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class SplashScreenController implements Initializable {

    @FXML StackPane rootPane;
    
  Stage stage = new Stage();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
            new SplashScreen().start();
    }  
    
    class SplashScreen extends Thread{
    
        
        
        
    @Override 
    public void run(){
    
        try {
            Thread.sleep(5000);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
             Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
             rootPane.getScene().getWindow().hide();     
             Scene scene = new Scene(root);
             stage.setScene(scene);
             scene.setFill(Color.WHITE);
             stage.setOpacity(1);
             stage.initStyle(StageStyle.UNDECORATED);
                  stage.show();
         
            
                }
            });
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    }
    
    
    
    }
    

