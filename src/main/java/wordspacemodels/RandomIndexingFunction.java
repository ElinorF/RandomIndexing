
package wordspacemodels;

import edu.ucla.sspace.common.SemanticSpace;
import edu.ucla.sspace.common.SemanticSpaceIO;
import edu.ucla.sspace.ri.RandomIndexing;
import edu.ucla.sspace.util.LineReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class RandomIndexingFunction {
        
    //static Connection conn = null;
    //static Statement stmt = null;
    
     public static SemanticSpace randomIndexing(String inputFile, String randomIndexingOutputFile, String vectorSize) throws Exception  {
        
        Properties p = System.getProperties();
        p.setProperty(RandomIndexing.VECTOR_LENGTH_PROPERTY, vectorSize); //cubicroot(1000*unique words) for 0.1% collision
        //p.setProperty(RandomIndexing.WINDOW_SIZE_PROPERTY, 2);
        RandomIndexing ri = new RandomIndexing(p); 

        ri.processDocument(new BufferedReader(new FileReader(inputFile)));

        SemanticSpaceIO.save(ri, new File(randomIndexingOutputFile));

        System.out.println("SemanticSpace written to file: "+randomIndexingOutputFile);
        
    	SemanticSpace sspaceObject = SemanticSpaceIO.load(new File(randomIndexingOutputFile));
        
        return sspaceObject;
    }
     
     public static SemanticSpace getSspaceObject(String randomIndexingOutputFile) throws IOException {
         return SemanticSpaceIO.load(new File(randomIndexingOutputFile));
     }
   
}


