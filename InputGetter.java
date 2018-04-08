
/**
 * @author Marcus Trujillo
 * Assignment Number: 
 * Description of program if main/ class otherwise 
 * 
 * CS2050-003
 * 
 */
import java.util.Scanner; 

public class InputGetter
{
    Scanner keyboard; 
    
    /**
     * Constructor
     */
    public InputGetter(){
        keyboard = new Scanner(System.in); 
    }
    
    
    /**
     * Recieves input from the user via the keyboard
     */
    public String takeInput(){
        String userText = ""; 
        try{
            userText = keyboard.nextLine(); 
        } catch (Exception ex){
            System.out.println("Couldn't get input"); 
        }
        return userText; 
    }
}
