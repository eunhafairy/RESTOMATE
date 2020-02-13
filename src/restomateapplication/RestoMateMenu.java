
package restomateapplication;

import javafx.beans.property.SimpleStringProperty;

public class RestoMateMenu {


   private int foodNo;
    private SimpleStringProperty foodName, foodDescription;
    private double price;

    public RestoMateMenu(String foodName, String foodDescription, double price, int foodNo) {
        this.foodName = new SimpleStringProperty (foodName);
        this.foodDescription = new SimpleStringProperty(foodDescription);
        this.price = price;
        this.foodNo = foodNo;
    }

    public String getFoodName() {
        return foodName.get();
    }

    public String getFoodDescription() {
        return foodDescription.get();
    }

    public double getPrice() {
        return price;
    }

    public void setFoodName(String foodName) {
        this.foodName = new SimpleStringProperty(foodName);
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = new SimpleStringProperty(foodDescription);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
    }
    
    
    
}
