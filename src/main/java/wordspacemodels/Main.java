
package wordspacemodels;

public class Main {
    
    public static void main(String[] args) throws Exception{
   
        // Define text file to process and name of output file
        // Define vector size. IF vector size set to 1000; cubicroot(1000*unique words) -> 0.1% collision
        String inputFile = "Data/Standard.txt";
        String outputFile = "Data/RandomIndexed.txt";
        String vectorSize = "1000";
        
        RandomIndexingFunction.randomIndexing(inputFile, outputFile, vectorSize);
                     
        
    }
    
}
