
package wordspacemodels;

import edu.ucla.sspace.common.SemanticSpace;
import edu.ucla.sspace.common.SemanticSpaceIO;
import edu.ucla.sspace.ri.RandomIndexing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class RandomIndexingFunction {
        
     public static SemanticSpace randomIndexing(String inputFile, String randomIndexingOutputFile, String vectorSize) throws Exception  {
        
        Properties p = System.getProperties();
        RandomIndexing ri = new RandomIndexing(p); 
        
        // Set vector size
        p.setProperty(RandomIndexing.VECTOR_LENGTH_PROPERTY, vectorSize); 
        
        // Random indexing input text
        ri.processDocument(new BufferedReader(new FileReader(inputFile)));

        // Saving random indexed output to file
        SemanticSpaceIO.save(ri, new File(randomIndexingOutputFile));        
    	SemanticSpace sspaceObject = SemanticSpaceIO.load(new File(randomIndexingOutputFile));
        
        return sspaceObject;
    }
     
     public static SemanticSpace getSspaceObject(String randomIndexingOutputFile) throws IOException {
         return SemanticSpaceIO.load(new File(randomIndexingOutputFile));
     }
   
}


