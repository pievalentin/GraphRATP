import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Pierre Valentin on 01/06/2017.
 */
public  class ReadJSON {
    public static void readStation() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Node[] nodes = mapper.readValue(new File("nodes.json"), Node[].class);
        Ligne[] lignes= mapper.readValue(new File("lignes.json"), Ligne[].class);
        System.out.println(nodes.toString()+lignes.toString());
    }

}
