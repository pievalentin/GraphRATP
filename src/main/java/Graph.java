import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sami- on 30/05/2017.
 */
public class Graph {
    public List<Node> getNodes() {
        return nodes;
    }

    private List<Node> nodes=new ArrayList<Node>();

    public List<Integer>[] getAdj() {
        return adj;
    }

    private List<Integer>[] adj=new ArrayList[302];

    /*public int indexOf(Node nodeToFind){
        int index=0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getName().equals(nodeToFind.getName())){
              index=i;
            }
        }  return index;
    }*/

    public void printAdj(String name){
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getName().equals(name) ){
                System.out.println("found!!");
                System.out.println(adj[i]);
                for (int j = 0; j < adj[i].size(); j++) {
                    nodes.get(adj[i].get(j)).print();
                }
            }
        }

    }
    public void addNodesToList() throws IOException {
        List<String> filePathes=new ArrayList<String>();
        filePathes.add("GTFS/RATP_GTFS_METRO_1/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_2/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_3/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_3b/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_4/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_5/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_6/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_7/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_7b/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_8/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_9/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_10/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_11/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_12/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_13/stops.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_14/stops.txt");

        for (String filePath: filePathes ) {
            List<Node> nodesToAdd= Script.readNode(filePath);
            for (Node nodeToAdd:nodesToAdd ) {
                    addNode(nodeToAdd);
                }
            }
        }

    private void addNode(Node nodeToAdd){
        boolean added=false;
        for (Node node:nodes ) {
            if (node.getName().equals(nodeToAdd.getName()) ){
                node.addId((Integer) nodeToAdd.getId().get(0));
                added = true;
            }
        }
        if(!added){
            nodes.add(nodeToAdd);
        }
    }

    public void addTransfersToAdjList() throws IOException {

        //create adj
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new ArrayList<Integer>();
        }
        List<String> filePathes=new ArrayList<String>();
        filePathes.add("GTFS/RATP_GTFS_METRO_1/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_2/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_3/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_3b/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_4/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_5/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_6/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_7/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_7b/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_8/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_9/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_10/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_11/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_12/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_13/transfers.txt");
        filePathes.add("GTFS/RATP_GTFS_METRO_14/transfers.txt");

        for (String filePath: filePathes ) {

            List<Transfer> transfersToAdd= Script.buildTransferList(filePath);
            for (Transfer transferToAdd:transfersToAdd ) {
                if(transferToAdd.getIdStation1()!=0 && transferToAdd.getIdStation2()!=0){//todo: pq y'a des 0?
                    addTransfer(transferToAdd.getIdStation1(),transferToAdd.getIdStation2());
                }
            }
        }
    }
    private void addTransfer(int idNode1,int idNode2){

        int node1=-1;
        int node2=-1;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getId().contains(idNode1) ){
                //node1=new Node(nodes.get(i));
                node1=i;
            }
            if (nodes.get(i).getId().contains(idNode2) ){
                //node2=new Node(nodes.get(i));
                node2=i;
            }
        }

try{
    if(node1!=node2 && node1>0 && node2>0){
        nodes.get(node1).print();nodes.get(node2).print();
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
}
