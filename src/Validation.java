
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS-PRO
 */
public class Validation {
    private final static Scanner sc = new Scanner(System.in);
    
    public static int CheckInputIntLimit(int min, int max){
        while(true){
            try{
            int result = Integer.parseInt(sc.nextLine().trim());
            if(result<min || result>max){
                throw new NumberFormatException();
            }
            return result;
            }catch(NumberFormatException e){
                System.out.println("Please input in rage["+min+","+max+"]");
                System.out.print("Enter again");
            }
        }
    }
    
    public static String checkInputString(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("Not Empty.");
                System.out.print("Enter again: ");
            }else{
                return result;
            }
        }
    }
    
    public static int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < 0){
                    throw new NumberFormatException();
                }
                return result;
            }catch(NumberFormatException e){
                System.out.println("Must be input int and greater than 0.");
                System.out.print("Enter again : ");
            }
        }
    }
    
    public static boolean checkExistID(ArrayList<Food> f, String id){
        for(Food food: f){
            if(id.equalsIgnoreCase(food.getId())){
                return false;
            }
        }
        return true;
    }
    
    
   public static boolean checkInputYN(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }
            if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please input y/Y or n/N");
            System.out.print("Enter again: ");
        }
    }
    
   public static boolean checkInputDelete(){
       while(true){
           String result = sc.nextLine().trim();
           if(result.equalsIgnoreCase("Y")){
               System.out.println("Remove success.");
               return true;
           }
           if(result.equalsIgnoreCase("N")){
               System.out.println("Remove fail");
               return false;
           }
           System.out.println("Please input y/Y or n/N");
           System.out.print("Enter again: ");
       }
   }
   
   public static boolean checkDuplicate(ArrayList<Food> f,String id, String Name, int weight, String type, String place, String expired_date){
       for(Food food:f){
           if(id.equalsIgnoreCase(food.getId())
                   && Name.equalsIgnoreCase(food.getName())
                   && weight == food.getWeight()
                   && type.equalsIgnoreCase(food.getType())
                   && place.equalsIgnoreCase(food.getPlace())
                   && expired_date.equalsIgnoreCase(food.getExpired_date())){
               return false;
           }          
       }
       return true;
   }
   
   public static String checkInputExpired_date(){
       while(true){
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/2021");
           try{
               String strdate = sc.nextLine().trim();
               /*Date date = sdf.parse(strdate);
               sdf.setLenient(false);
               System.out.println(date);
               return strdate;*/
               sdf.setLenient(false);
               sdf.parse(strdate);
               Date date = sdf.parse(strdate);
               System.out.println(date);
               return strdate;
           }catch(ParseException e){
               System.err.println("Must input like format dd/MM/2021 and dd>0&&0<MM<12");
               System.out.print("Enter again: ");
           }
       }
   }
}
