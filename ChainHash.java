
/**
 * @author Marcus Trujillo
 * Assignment Number: 
 * Description of program if main/ class otherwise 
 * 
 * CS2050-003
 * 
 */
import java.io.*;
import java.util.Scanner; 
public class ChainHash
{
    BufferedReader reader; 
    Scanner keyboard; 
    int[] hashTable; 
    
    
    /**
     * Constructor
     */
    public ChainHash(){
        keyboard = new Scanner(System.in); 
    }
    
    
    /**
     * Takes the key, makes a hashcode and puts it into the table. 
     */
    private void hash(int key){
        int hashCode = key % 1231; 
        
    }
    
    
    /**
     * Recieves input from the user via the keyboard
     */
    private String getInput(){
        String userText = ""; 
        try{
            userText = keyboard.nextLine(); 
        } catch (Exception ex){
            System.out.println("Couldn't get input"); 
        }
        return userText; 
    }
    
}
