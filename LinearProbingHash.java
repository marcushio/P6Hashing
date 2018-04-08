
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

public class LinearProbingHash
{
    Timer timer; 
    InputGetter keyboard; 
    String inputFilename; 
    String outputFilename; 
    
    Integer[] hashTable1; 
    int size1 = 11000; 
    int collisions1; 
    int furthest1; 
    
    Integer[] hashTable2;
    int size2 = 15707; 
    int collisions2; 
    int furthest2; 
    
    Integer[] hashTable3;
    int size3 = 17111; 
    int collisions3; 
    int furthest3; 
    
    Integer[] hashTable4; 
    int size4 = 25111; 
    int collisions4; 
    int furthest4; 

    int totalCollisions; 
    int furthest; 
    String ls = System.lineSeparator(); 
    
    /**
     * 
     */
    public LinearProbingHash(){
        keyboard = new InputGetter(); 
        timer = new Timer(); 
    
        hashTable1 = new Integer[size1]; 
        hashTable2 = new Integer[size2]; 
        hashTable3 = new Integer[size3]; 
        hashTable4 = new Integer[size4]; 
        
        System.out.println("Enter a .txt filename you wish to hash"); 
        inputFilename = keyboard.takeInput(); 
        
        System.out.println("Enter the name of the file you want to write results to"); 
        outputFilename = keyboard.takeInput(); 
    }
    
    
    /**
     * Hash
     */
    private void hash(Integer[] hashTable, int size) throws FullTableException{
        totalCollisions = 0; 
        furthest = 0; 
        int tours = 0; 
        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
            String docLine = null; 
            
            while((docLine = reader.readLine()) != null){
                int key = Integer.parseInt(docLine); 
                int hashCode = key % 1231; 
                int keyCollisions = 0; 
                while(hashTable[hashCode] != null){
                    totalCollisions++; 
                    keyCollisions++;
                    hashCode++; 
                    if(hashCode == size){
                        hashCode = 0; 
                        tours++; 
                    }
                    if(keyCollisions > furthest){
                        furthest = keyCollisions; 
                    }
                    if(tours == 2){
                        throw new FullTableException("No available open addresses"); 
                    }
                }   
                hashTable[hashCode] = key; 
            }
            reader.close(); 
        }catch(NumberFormatException ex){
            System.out.println("Error: Non numeric characters"); 
            writeResults("Error: non numeric characters in file (hash invalid)" + ls); 
        }catch(IOException ex){
            System.out.println("IO Error"); 
        }
    }
    
    
    /**
     * 
     */
    private void writeResults(String results){      
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFilename), true))){
            writer.write(results); 
        }catch(Exception ex){
            System.out.println("couldn't write results"); 
        }
    }
    
    
    /**
     * 
     */
    private class FullTableException extends Throwable{
        String errorMessage; 
        private FullTableException(String errorMessage){
            this.errorMessage = errorMessage; 
        }
        
        public String toString(){
            return errorMessage; 
        }
    }
    
    /**
     * 
     */
    public static void main(String[] args){
        LinearProbingHash hash = new LinearProbingHash(); 
        
        try{
            hash.timer.start(); 
            hash.hash(hash.hashTable1, hash.size1); 
            hash.timer.stop(); 
            hash.collisions1 = hash.totalCollisions; 
            hash.furthest1 = hash.furthest; 
            System.out.println("Hash time 11000 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions1 + hash.ls); 
            System.out.println("furthest" + hash.furthest1 + hash.ls); 
            hash.writeResults("Results for size = 11000" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls + 
                              "Collisions: " + hash.collisions1 + hash.ls + 
                              "Furthest Collision: " + hash.furthest1 + hash.ls + hash.ls); 
            
            hash.timer.start(); 
            hash.hash(hash.hashTable2, hash.size2); 
            hash.timer.stop(); 
            hash.collisions2 = hash.totalCollisions; 
            hash.furthest2 = hash.furthest; 
            System.out.println("Hash time 15707 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions2 + hash.ls); 
            System.out.println("furthest" + hash.furthest2 + hash.ls);
            hash.writeResults("Results for size = 15707" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls +
                              "Collisions: " + hash.collisions2 + hash.ls +
                              "Furthest Collision: " + hash.furthest2 + hash.ls + hash.ls); 
            
            hash.timer.start(); 
            hash.hash(hash.hashTable3, hash.size3); 
            hash.timer.stop(); 
            hash.collisions3 = hash.totalCollisions; 
            hash.furthest3 = hash.furthest; 
            System.out.println("Hash time 17111 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions3 + hash.ls); 
            System.out.println("furthest" + hash.furthest3 + hash.ls); 
            hash.writeResults("Results for size = 17111" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls +
                              "Collisions: " + hash.collisions3 + hash.ls +
                              "Furthest Collision: " + hash.furthest3 + hash.ls + hash.ls); 
            
            hash.timer.start(); 
            hash.hash(hash.hashTable4, hash.size4); 
            hash.timer.stop(); 
            hash.collisions4 = hash.totalCollisions; 
            hash.furthest4 = hash.furthest; 
            System.out.println("Hash time 25111" + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions4 + hash.ls); 
            System.out.println("furthest" + hash.furthest4 + hash.ls); 
            hash.writeResults("Results for size = 25111" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls +
                              "Collisions: " + hash.collisions4 + hash.ls +
                              "Furthest Collision: " + hash.furthest4 + hash.ls + hash.ls); 
            
        }catch(FullTableException ex){
            System.out.println("Error: no open addresses"); 
            hash.writeResults("Error: no open addresses (invalid hash)"); 
        } catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Hashes to an index out of bounds, try a different table size next time"); 
            hash.writeResults("Error: Hashes to an index out of bounds"); 
        }catch(Exception ex){
            System.out.println("Exception occurred"); 
        }
    }
}
