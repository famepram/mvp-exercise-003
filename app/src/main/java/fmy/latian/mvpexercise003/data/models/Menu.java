package fmy.latian.mvpexercise003.data.models;

/**
 * Created by Femmy on 8/2/2017.
 */

public class Menu {

    private String id;

    private String name;

    private String category;

    private int price;

    public Menu(){}

    public Menu(String name, String category, int Price){
        setName(name);
        setCategory(category);
        setPrice(Price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isNameCorrect(){
        if(this.name != ""){
            return true;
        }
        return false;
    }

    public boolean isCategoryCorrect(){
        if(this.category != ""){
            return true;
        }
        return false;
    }

    public boolean isPriceCorrect(){
        if(this.price > 0){
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
