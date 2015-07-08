
package wordspacemodels;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        //String folder = ""; 
        String inputFile = "";
        String outputFile = "";
        String vectorSize= "";
                    
        if(args.length == 0){
             inputFile = "../Already_Standard.txt";
             outputFile = "../RandomIndexed_Standard.txt";
             vectorSize = "1000";
        }
        else if(args.length == 1){
             inputFile = args[0];
             outputFile = "RandomIndexed_"+args[0]+".txt";
             vectorSize = "1000";
        } 
        else if(args.length == 2){
             inputFile = args[0];
             outputFile = "RandomIndexed_"+args[0]+".txt";
             vectorSize = args[1];
             
        }
        
        RandomIndexingFunction.randomIndexing(inputFile, outputFile, vectorSize);
                
                
                
                
                
        
    }
    
}
