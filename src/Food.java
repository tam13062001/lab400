/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS-PRO
 */
public class Food {
    private String id;
    private String Name;
    private int weight;
    private String type;
    private String place;
    private String expired_date;
    

    public Food(String id, String Name, int weight, String type, String place, String expired_date) {
        this.id = id;
        this.Name = Name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expired_date = expired_date;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }
    
    public int CompareTo(Food f){
        return getExpired_date().compareTo(f.getExpired_date());
    }
}
