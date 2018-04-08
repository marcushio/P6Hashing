
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
import java.util.LinkedList; 
public class ChainHash
{
    BufferedReader reader; 
    Timer timer; 
    InputGetter keyboard; 
    String filename; 
    
    LinkedList[] hashTable; 
    LinkedList longestChain; 
    int longestChainLocation; 
    int collisions; 
    
    /**
     * Constructor
     */
    public ChainHash(int tableCapacity){
        keyboard = new InputGetter(); 
        timer = new Timer(); 
        hashTable = new LinkedList[tableCapacity]; 
    }
    
    
    /**
     * Takes the key, makes a hashcode and puts it into the table while .txt file 
     * has lines to read.
     */
    private void hash(){
        try{
            String docLine = null; 
            longestChain = null; 
            while((docLine = reader.readLine()) != null){
                    int key = Integer.parseInt(docLine); 
                    int hashCode = key % 1231; 
                    if(hashTable[hashCode] != null){
                        hashTable[hashCode].add(key); 
                        collisions++; 
                        if(hashTable[hashCode].size() > longestChain.size()){
                            longestChain = hashTable[hashCode]; 
                            longestChainLocation = hashCode; 
                        }
                    } else {
                        hashTable[hashCode] = new LinkedList(); 
                        hashTable[hashCode].add(key); 
                    }   
            }  
        }catch(NumberFormatException ex){
            System.out.println("Error: Non numeric characters"); 
        }catch(IOException ex){
            System.out.println("IO Error"); 
        }
    }
    
    
    
    
    /**
     * main method
     */
    public static void main(String[] args){
        ChainHash hash = new ChainHash(11000); 
        System.out.println("Enter .txt file that contains the keys you wish to hash");
        hash.filename = hash.keyboard.takeInput(); 
        try{
            hash.reader = new BufferedReader(new FileReader(hash.filename));
            hash.timer.start(); 
            hash.hash(); 
            hash.timer.stop(); 
            System.out.println(hash.timer.reportTimes()); 
            System.out.println(hash.collisions + System.lineSeparator()); 
            System.out.println(hash.longestChainLocation); 
        }catch(Exception ex){
            System.out.println("Problem with file reading"); 
        }
        
    }
}
