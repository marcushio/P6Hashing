
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

public class LinearProbingHash
{
    Scanner keyboard; 
    
    /**
     * 
     */
    public LinearProbingHash(){
        keyboard = new Scanner(System.in); 
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