
/**
 * @author Marcus Trujillo
 * Assignment Number: 6
 * Takes a .txt file full of int keys and hashes them into a table. Collisions are handled through
 * seperate chaining. For this assignment there were four different table sizes. 
 * 
 * CS2050-003
 * 
 */
import java.io.*;
import java.util.Scanner; 
import java.util.LinkedList; 

public class ChainHash
{
    Timer timer; 
    InputGetter keyboard; 
    String inputFilename; 
    String outputFilename; 
    String ls = System.lineSeparator(); 
    
    LinkedList[] hashTable1; 
    LinkedList longestChain1; 
    int longestChainLocation1; 
    int collisions1; 
    
    LinkedList[] hashTable2;
    LinkedList longestChain2; 
    int longestChainLocation2; 
    int collisions2; 
    
    LinkedList[] hashTable3;
    LinkedList longestChain3; 
    int longestChainLocation3; 
    int collisions3; 
    
    LinkedList[] hashTable4;  
    LinkedList longestChain4; 
    int longestChainLocation4; 
    int collisions4; 
    
    LinkedList longestChain;
    int longestChainLocation; 
    int collisions;
    
    /**
     * Instantiates all four tables that we're going to fill with keys. Also takes the filenames 
     * needed from the user. 
     */
    public ChainHash(){
        keyboard = new InputGetter(); 
        timer = new Timer(); 
        
        hashTable1 = new LinkedList[11000]; 
        hashTable2 = new LinkedList[15707]; 
        hashTable3 = new LinkedList[17111]; 
        hashTable4 = new LinkedList[25111]; 
        
        System.out.println("Enter a .txt filename you wish to hash"); 
        inputFilename = keyboard.takeInput(); 
        
        System.out.println("Enter the name of the file you want to write results to"); 
        outputFilename = keyboard.takeInput(); 
    }
    
    
    /**
     * Takes the key, makes a hashcode and puts it into the table while .txt file 
     * has lines to read.
     */
    private void hash(LinkedList[] hashTable){
        collisions = 0; 
        longestChain = new LinkedList(); 
        longestChainLocation = 0; 
        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
            String docLine = null; 
            
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
            reader.close(); 
        }catch(NumberFormatException ex){
            System.out.println("Error: Non numeric characters"); 
            writeResults("Error: non numeric characters in file (hash invalid)" + ls); 
        }catch(IOException ex){
            System.out.println("IO Error"); 
        }
    }
    
    
    /**
     * Writes the results to a text file the user chose. 
     */
    private void writeResults(String results){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFilename), true))){
            writer.write(results); 
        }catch(Exception ex){
            System.out.println("couldn't write results"); 
        }
    }
    
    /**
     * main method that runs the hash function for all tables. 
     */
    public static void main(String[] args){
        ChainHash hash = new ChainHash(); 
        
        try{
            hash.timer.start(); 
            hash.hash(hash.hashTable1); 
            hash.timer.stop(); 
            hash.collisions1 = hash.collisions; 
            hash.longestChainLocation1 = hash.longestChainLocation; 
            hash.longestChain1 = hash.longestChain; 
            System.out.println("Hash time 11000 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions1 + hash.ls); 
            System.out.println("Longest chain index" + hash.longestChainLocation1 + hash.ls);
            System.out.println("Longest chain length" + hash.longestChain1.size()); 
            hash.writeResults("Results for size = 11000" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() +  hash.ls +
                              "Collisions: " + hash.collisions1 + hash.ls +
                              "Longest chain index: " + hash.longestChainLocation1 + hash.ls +
                              "Longest chain length: " + hash.longestChain1.size() + hash.ls + hash.ls); 
            
            hash.timer.start(); 
            hash.hash(hash.hashTable2); 
            hash.timer.stop(); 
            hash.collisions2 = hash.collisions; 
            hash.longestChainLocation2 = hash.longestChainLocation; 
            hash.longestChain2 = hash.longestChain; 
            System.out.println("Hash time 15707 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions2 + hash.ls); 
            System.out.println("Longest chain index" + hash.longestChainLocation2 + hash.ls);
            System.out.println("Longest chain length" + hash.longestChain2.size()); 
            hash.writeResults("Results for size = 15707" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls +
                              "Collisions: " + hash.collisions2 + hash.ls +
                              "Longest chain index: " + hash.longestChainLocation2 + hash.ls +
                              "Longest chain length: " + hash.longestChain2.size() + hash.ls + hash.ls); 
            
            hash.timer.start(); 
            hash.hash(hash.hashTable3); 
            hash.timer.stop(); 
            hash.collisions3 = hash.collisions; 
            hash.longestChainLocation3 = hash.longestChainLocation; 
            hash.longestChain3 = hash.longestChain; 
            System.out.println("Hash time 17111 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions3 + hash.ls); 
            System.out.println("Longest chain index" + hash.longestChainLocation3 + hash.ls);
            System.out.println("Longest chain length" + hash.longestChain3.size()); 
            hash.writeResults("Results for size = 17111" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls +
                              "Collisions: " + hash.collisions3 + hash.ls +
                              "Longest chain index: " + hash.longestChainLocation3 + hash.ls +
                              "Longest chain length: " + hash.longestChain3.size() + hash.ls + hash.ls); 
            
            hash.timer.start(); 
            hash.hash(hash.hashTable4); 
            hash.timer.stop(); 
            hash.collisions4 = hash.collisions; 
            hash.longestChainLocation4 = hash.longestChainLocation; 
            hash.longestChain4 = hash.longestChain; 
            System.out.println("Hash time 25111 " + hash.timer.reportTimes() + hash.ls); 
            System.out.println("Collisions " + hash.collisions4 + hash.ls); 
            System.out.println("Longest chain index" + hash.longestChainLocation4 + hash.ls);
            System.out.println("Longest chain length" + hash.longestChain4.size()); 
            hash.writeResults("Results for size = 25111" + hash.ls + 
                              "Time to Hash: " + hash.timer.reportTimes() + hash.ls +
                              "Collisions: " + hash.collisions4 + hash.ls +
                              "Longest chain index: " + hash.longestChainLocation4 + hash.ls +
                              "Longest chain length: " + hash.longestChain4.size() + hash.ls + hash.ls); 
          
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("hashes to index out of bounds"); 
            hash.writeResults("Hashes to and index out of bounds"); 
        }catch(Exception ex){
            System.out.println("Problem with file reading"); 
        }
    }
}
