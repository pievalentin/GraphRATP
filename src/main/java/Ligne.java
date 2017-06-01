import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sami- on 01/06/2017.
 */

@JsonIgnoreProperties(value = {"name","color","type","labels"})
public class Ligne {
    String[][] arrets;
    String num;

    public Ligne(String[][] arrets, String num) {
        this.arrets = arrets;
        this.num = num;
    }
    public Ligne(){

    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String[][] getArrets() {
        return arrets;
    }

    public void setArrets(String[][] arrets) {
        this.arrets = arrets;
    }

}
