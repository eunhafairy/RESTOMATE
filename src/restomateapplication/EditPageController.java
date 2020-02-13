/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restomateapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pisonet2
 */
public class EditPageController implements Initializable {

    
//declaring table and columns
    @FXML private TableView<RestoMateMenu> tableView;
    @FXML private TableColumn<RestoMateMenu, String> nameColumn ;
    @FXML private TableColumn<RestoMateMenu, Double> priceColumn ;
    @FXML private TableColumn<RestoMateMenu, String> descColumn ;
    @FXML private TableColumn<RestoMateMenu, String> noColumn ;
    
    
   //methods for editing cells
   public void changeNameCellEvent(CellEditEvent eventNew){
  
   RestoMateMenu foodSelected = tableView.getSelectionModel().getSelectedItem();
   foodSelected.setFoodName(eventNew.getNewValue().toString());
       
   }
    public void changeDescCellEvent(CellEditEvent eventNew){
   RestoMateMenu descSelected = tableView.getSelectionModel().getSelectedItem();
   descSelected.setFoodDescription(eventNew.getNewValue().toString());
       
   }
   /*
   public void commitDescChanges(CellEdit event) throws IOException{
        
        RestoMateMenu descSelected = tableView.getSelectionModel().getSelectedItem();
       descSelected.setFoodDescription(event.getNewValue().toString());
        
    
    } 
    */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //initializing table properties
        nameColumn.setCellValueFactory(new PropertyValueFactory<RestoMateMenu, String>("foodName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<RestoMateMenu, Double>("price"));
        descColumn.setCellValueFactory(new PropertyValueFactory<RestoMateMenu, String>("foodDescription"));
        noColumn.setCellValueFactory(new PropertyValueFactory<RestoMateMenu, String>("foodNo"));
        tableView.setItems(getFood());
        
        
        //allow table to change
        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }    
    
    //method for adding table properties
    public ObservableList<RestoMateMenu> getFood()
    {
    ObservableList <RestoMateMenu> food = FXCollections.observableArrayList();
    food.add(new RestoMateMenu("Caprese Salad with Pesto Sauce","This is a description",756.00,1));
    
    return food;
    
    }
    
}
