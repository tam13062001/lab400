
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS-PRO
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Food> f = new ArrayList<>();
        
        while(true){
            int choice = Manager.menu();
            Manager.AddFromFile(f,"Food.dat");
            switch(choice){
                case 1:
                    Manager.Add(f);
                    break;
                case 2:
                    Manager.searchFoodByName(f);
                    break;
                case 3:
                    Manager.removeFood(f);
                    break;
                case 4:
                    Manager.sort(f);
                    break;
                case 5:
                    Manager.SaveFile(f,"Food.dat");
                    break;
                case 6:
                    return;
            }
        }
        // TODO code application logic here
    }
    
}
