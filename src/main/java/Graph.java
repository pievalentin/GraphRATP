import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sami- on 30/05/2017.
 */
public class Graph {

    //private List<Node> nodes=new ArrayList<Node>();
    private Node[] nodes;


    private List<Integer>[] adj;

    public Graph() throws IOException {
        this.nodes=ReadJSON.readStation();
        this.addTransfersToAdjList();
    }

    public void addTransfersToAdjList() throws IOException {
        Ligne[] lines=ReadJSON.readLines();
        adj=new ArrayList[getGraphOrder()];
        //create adj
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new ArrayList<Integer>();
        }
        for (Ligne line: lines ) {

            for (int i = 0; i < line.getArrets().length; i++) {
                for (int j = 0; j < line.getArrets()[i].length-1; j++) {
                   // if(Integer.parseInt(line.getArrets()[i][j])!=0 && Integer.parseInt(line.getArrets()[i][j+1])!=0){
                        addTransfer(Integer.parseInt(line.getArrets()[i][j]),Integer.parseInt(line.getArrets()[i][j+1]));
                   // }
                }
            }


        }
    }
    private void addTransfer(int idNode1,int idNode2){

        int node1=-1;
        int node2=-1;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getNum()==idNode1 ){
                //node1=new Node(nodes.get(i));
                node1=i;
            }
            if (nodes[i].getNum()==idNode2 ){
                //node2=new Node(nodes.get(i));
                node2=i;
            }
        }

        try{
            if(node1!=node2 && node1>=0 && node2>=0){

                if(!adj[node1].contains(node2)){
                    adj[node1].add(node2);
                }

                if(!adj[node2].contains(node1)){
                    adj[node2].add(node1);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public int indexOfName(String name){
        int index=0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getNom().equals(name)){
              index=i;
            }
        }  return index;
    }

    public void printAdj(String name){
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getNom().equals(name) ){
                System.out.println("found!!");
                System.out.println(adj[i]);
                for (int j = 0; j < adj[i].size(); j++) {
                   nodes[adj[i].get(j)].print();
                }
            }
        }
    }

    public void printAdj(){
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i+" : "+nodes[i].getNom()+" : ");
            for (int j = 0; j < adj[i].size(); j++) {

                System.out.print(nodes[adj[i].get(j)].getNom()+" | ");
            }
            System.out.println();
        }
    }

    public double getDistance(Node node1, Node node2){
        return Math.sqrt(
                Math.abs(
                        Double.parseDouble(node1.getLat())-(Double.parseDouble(node2.getLat())) )
                        +Math.abs(
                        Double.parseDouble(node1.getLng())-(Double.parseDouble(node2.getLng())) ));
    }
    public double getDistance(int id1, int id2){
        double dist= Math.sqrt(
                Math.abs(
                    Math.pow(Double.parseDouble(nodes[id1].getLat())-(Double.parseDouble(nodes[id2].getLat())),2) )
                +Math.abs(
                    Math.pow(Double.parseDouble(nodes[id1].getLng())-(Double.parseDouble(nodes[id2].getLng())),2) ) );
        return dist;
    }


    public Node[] getNodes() {
        return nodes;
    }

    public List<Integer>[] getAdj() {
        return adj;
    }

    public int getGraphOrder() {
        return nodes.length;
    }

    public List<Integer> neighbors(Integer integer) {//todo
        return new ArrayList<>();
    }
}
