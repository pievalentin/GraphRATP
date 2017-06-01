/**
 * Created by Pierre Valentin on 01/06/2017.
 */
public class Station {
    private String commune;
    private String lat;
    private String lng;
    private String nom;
    private String type;
    private int num;
    private int[] metro;

    public Station(String type, String nom, int num, int[] metro) {
        this.type = type;
        this.nom = nom;
        this.num = num;
        this.metro = metro;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int[] getMetro() {
        return metro;
    }

    public void setMetro(int[] metro) {
        this.metro = metro;
    }
}
