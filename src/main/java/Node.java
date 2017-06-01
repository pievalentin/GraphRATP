/**
 * Created by Pierre Valentin on 01/06/2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"lignes","isHub","routes","stations","isAmbiguous" })
public class Node {
    private String lat;
    private String lng;
    private String nom;
    private String type;
    private int num;
    private int[] metro;
    private String commune;


    public Node(String lat, String lng, String nom, String type, int num, int[] metro, String commune) {
        this.lat = lat;
        this.lng = lng;
        this.nom = nom;
        this.type = type;
        this.num = num;
        this.metro = metro;
        this.commune = commune;
    }
    public Node(Node nodeToClone) {
        this.lat = nodeToClone.getLat();
        this.lng = nodeToClone.getLng();
        this.nom = nodeToClone.getNom();
        this.type = nodeToClone.getType();
        this.num = nodeToClone.getNum();
        this.metro = nodeToClone.getMetro();
        this.commune = nodeToClone.getCommune();

    }

    public Node() {
    }

    public void print(){
        System.out.println("Nom : "+this.getNom()+"  ");
        System.out.print("ligne : "+this.getMetro());
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
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