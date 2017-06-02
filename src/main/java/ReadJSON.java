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

    public static Node[] fakeStation(){
        Node[] result = {
                new Node("1","10",1),
                new Node("2","30",2),
                new Node("4","10",3),
                new Node("6","30",4),
                new Node ("10","15",5),
                new Node("8","7",6)

        };
        return result;
    }
    public static Ligne fakeLigne(){
        String[][] toSend = {{"1","2","3","5"},{"2","4","5","6","3","1"}};
        Ligne result = new Ligne(toSend,"1");
        return result;
    }

}
