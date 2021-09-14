
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS-PRO
 */
public class Manager {
    public static int menu(){
        System.out.println("1. Add a new food");
        System.out.println("2. Search a food by name");
        System.out.println("3. Remove the food by ID");
        System.out.println("4. Print the food list in the descending order of expired date");
        System.out.println("5. Save File");
        System.out.println("6. Exist.");
        System.out.println("Enter your choice: ");
        int choice = Validation.CheckInputIntLimit(1, 6);
        return choice;
    }
    
    public static void Add(ArrayList<Food> f){
        while(true){
        System.out.print("\nEnter id: ");
        String id = Validation.checkInputString();
        if(!Validation.checkExistID(f, id)){
            System.out.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        System.out.print("Enter weight: ");
        int weight = Validation.checkInputInt();
        System.out.print("Enter type: ");
        String type = Validation.checkInputString();
        System.out.print("Enter place: ");
        String place = Validation.checkInputString();
        System.out.print("Enter expired date: ");
        String date = Validation.checkInputExpired_date();
        if(!Validation.checkDuplicate(f, id, name, weight, type, place, date)){
            System.out.println("Dupilcate");
            return;
        }
        f.add(new Food(id,name,weight,type,place,date));
        System.out.println("Add success.");
        System.out.println("Do you want to continue(Y/N)?");
        if(!Validation.checkInputYN()){
            return;
        }
        } 
    }
    
    public static Food getFoodById(ArrayList<Food> f,String id){
        for(Food food: f){
            if(id.equalsIgnoreCase(food.getId())){
                return food;
            }
        }
        return null;
    }
    
    public static ArrayList<Food> listFoundByName(ArrayList<Food> f,String Name){
        ArrayList<Food> listFoundByName = new ArrayList<>();
        for(Food food : f){
            if(food.getName().equalsIgnoreCase(Name)){
                listFoundByName.add(food);
            }
        }
        return listFoundByName;
    }
    
    public static void searchFoodByName(ArrayList<Food> f){
        while(true){
        System.out.print("\nEnter name: ");
        String name = Validation.checkInputString();
        ArrayList<Food> listFoundByName = listFoundByName(f,name);
        if(listFoundByName.isEmpty()){
            System.out.println("List Empty.");
        }else{
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n","id","Name","weight","type","place","expired_date");
            for(Food food: f){
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", food.getId(),food.getName(),
                        food.getWeight(),food.getType(),food.getPlace(),food.getExpired_date());
            }
        }
        System.out.println("Do you want to Continue(Y/N)?");
        if(!Validation.checkInputYN()){
            return;
        }
        }
    }
    
    public static void removeFood(ArrayList<Food> f){
        System.out.print("\nEnter id: ");
        String id = Validation.checkInputString();
        Food food = getFoodById(f,id);
        if(food == null){
            System.out.println("Not Found");
        }else{
            System.out.println("Do you want to remove this food");
            if(!Validation.checkInputDelete()){
                return;
            }
            f.remove(food);
        }
    }  
    
    public static void sort(ArrayList<Food> f){
        if(f.isEmpty()){
            System.out.println("List Empty.");
            return;
        }
        Collections.sort(f, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getExpired_date().compareTo(o1.getExpired_date());
            }
        });
            System.out.println("\nthe food list in the descending order of expired date: ");
            System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n", "id","Name","weight","type","place","expired_date");
            for(Food food: f){
                System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n", food.getId(),food.getName(),
                        food.getWeight(),food.getType(),food.getPlace(),food.getExpired_date());
            }
        }
    
    public static void AddFromFile(ArrayList<Food> f, String fname) {
        File  file = new File("Food.txt");
        if(!file.exists()){
            System.out.println("Not Exist");
            return;
        }
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String ch;
            while((ch = br.readLine()) != null){
                String txt[] = ch.split(";");
                String id = txt[0].trim();
                String name = txt[1].trim();
                int weight = Integer.parseInt(txt[3].trim());
                String type = txt[2].trim();
                String place = txt[3].trim();
                String date = txt[4].trim();
                f.add(new Food(id,name,weight,type,place,date));
            }
            fr.close();
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }  
    }
    
    public static void SaveFile(ArrayList<Food> f,String fname){
       File file = new File("Food.txt");
       if(!file.exists()){
           System.out.println("Not exist.");
           return;
       }
       try{
           FileWriter fw = new FileWriter(file);
           PrintWriter pw = new PrintWriter(fw);
           for(Food food:f){
               pw.println("ID :"+food.getId()
                       + " Name: "+food.getName()
                       +" Weight: "+food.getWeight()
                       +" Type: "+food.getType()
                       +" Place: "+food.getType()
                       +" Expired date: "+food.getExpired_date()+"\n");
               /*pw.println(food.getName());
               pw.println(food.getWeight());
               pw.println(food.getType());
               pw.println(food.getPlace());
               pw.println(food.getExpired_date());*/
               pw.flush();
           }
           fw.close();
           pw.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }

    }
    




