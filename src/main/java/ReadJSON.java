import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Pierre Valentin on 01/06/2017.
 */
public  class ReadJSON {
    public static Station[] readStation() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("test.json"), Station[].class);
    }
}
