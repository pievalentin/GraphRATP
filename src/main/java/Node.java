import java.util.ArrayList;
import java.util.List;

/**
 * Created by sami- on 30/05/2017.
 */
public class Node {

    private List<Integer> id= new ArrayList<Integer>();;
    private double lat;
    private double lon;
    private String name;

    public Node(int id, double lat, double lon, String name) {
        this.id.add(id);
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }
    public Node(Node nodeClone) {
        this.id.add((Integer) nodeClone.getId().get(0));
        this.lat = nodeClone.getLat();
        this.lon = nodeClone.getLon();
        this.name = nodeClone.getName();
    }
    public Node() {

    }
    public void print(){
        System.out.println(name +" | "+ id.toString());
    }

    public List getId() {
        return id;
    }

    public void addId(int id){
        this.id.add(id);
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }


}
