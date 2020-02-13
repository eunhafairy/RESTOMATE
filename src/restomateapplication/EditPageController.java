/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restomateapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class EditPageController implements Initializable {

    
//declaring table and columns
    @FXML private TableView<RestoMateMenu> tableView;
    @FXML private TableColumn<RestoMateMenu, String> nameColumn ;
    @FXML private TableColumn<RestoMateMenu, Double> priceColumn ;
    @FXML private TableColumn<RestoMateMenu, String> descColumn ;
    @FXML private TableColumn<RestoMateMenu, String> noColumn ;
   
    // declaring textfields for adding new instance of RestoMateMenu class
    @FXML private TextField tField_foodName;
    @FXML private TextField tField_foodDesc;
    @FXML private TextField tField_foodPrice;
    @FXML private TextField tField_foodNo;
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
        
        // allow table to select multiple rows
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
    //method for adding table properties
    public ObservableList<RestoMateMenu> getFood()
    {
    ObservableList <RestoMateMenu> food = FXCollections.observableArrayList();
    food.add(new RestoMateMenu("Caprese Salad with Pesto Sauce","This is a description",756.00,1));
    
    return food;
    
    }
    
    //method for adding new instance of RestoMateMenu class
    public void addNewInstanceFood()
    {
    RestoMateMenu newFood = new RestoMateMenu(tField_foodName.getText(), tField_foodDesc.getText(),Double.parseDouble(tField_foodPrice.getText()),Integer.parseInt(tField_foodNo.getText()));
    tableView.getItems().add(newFood);
    
    }
    
    //method for deleting selected rows
    public void deleteSelected(){
    ObservableList<RestoMateMenu> rowsSelected, allFood;
    allFood = tableView.getItems();
    
    //get the selected rows and delete it 
    rowsSelected = tableView.getSelectionModel().getSelectedItems();
    allFood.removeAll(rowsSelected);
    
    }
    
}
