
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsmith
 */
public class TestEmployee {
    
    public static void main(String[] args) {
        
        //Array list to store employee info
        ArrayList <Employee> employeeInfo = new ArrayList();
        
        //Three employee objects 
        Employee emp001 = new Employee("001emp", 4590.99);
        Employee emp002 = new Employee("002emp", 27992.00);
        Employee emp003 = new Employee("003emp", 12321.56);
        
        //Employee objects added to Array list
        employeeInfo.add(emp001);
        employeeInfo.add(emp002);
        employeeInfo.add(emp003);
        
        //Serialize store to file 
        try {
            FileOutputStream fileOut = new FileOutputStream("employeeInfo.ser"); //file to which data is to be saved 
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employeeInfo); //write object
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employeeInfo.ser"); 
        
        } catch(FileNotFoundException i){
            i.printStackTrace();
        
        } catch(IOException i){
            i.printStackTrace();
        }
        
        //Deserialize data
        //ArrayList to store deserialized data
        ArrayList <Employee> employeeInfoDeserialized = new ArrayList(); //create an ArrayList to read the information the same way it was stored 
        
        try{
           FileInputStream fileIn = new FileInputStream("employeeInfo.ser"); //file from which data is to be read
           ObjectInputStream in = new ObjectInputStream(fileIn);
           employeeInfoDeserialized = (ArrayList <Employee>)in.readObject(); //cast read object so it can be read the same way it was stored
           System.out.println(employeeInfoDeserialized.toString());
           in.close();
           fileIn.close();
           return;
        
        } catch (IOException i){
            i.printStackTrace();
            
        } catch(ClassNotFoundException i){
            i.printStackTrace();
            return;
        }
    
    }    
    
}
