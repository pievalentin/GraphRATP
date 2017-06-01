import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Pierre Valentin on 01/06/2017.
 */
public  class ReadJSON {
    public static void readStation() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Station[] stations= mapper.readValue(new File("stations.json"), Station[].class);
        Ligne[] lignes= mapper.readValue(new File("lignes.json"), Ligne[].class);
        System.out.println(stations.toString()+lignes.toString());
    }

}
