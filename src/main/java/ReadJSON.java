import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Pierre Valentin on 01/06/2017.
 */
public  class ReadJSON {
    public static Node[] readStation() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("stations.json"), Node[].class);
    }
    public static Ligne[] readLines() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("lignes.json"), Ligne[].class);
    }

}
