import com.sun.corba.se.impl.orbutil.graph.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Pierre Valentin on 19/05/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //System.out.println("hello world");
        Graph graph=new Graph();
        System.out.println(graph.getNodes().length);

           /* List<Transfer> list = Script.buildTransferList("GTFS/RATP_GTFS_METRO_1/transfers.txt");
        for (int i = 0; i < list.size(); i++) {
                System.out.print(i+" : "+list.get(i).getIdStation1()+" | "+ list.get(i).getIdStation2());
            System.out.println();
        }
        System.out.println(list.size());*/
        /*for (int i = 0; i < graph.getAdj().length; i++) {
            size+=graph.getAdj()[i].size();
            System.out.println(graph.getAdj()[i].toString());
        }*/
        //graph.printAdj("Invalides");
        graph.printAdj();
        ShortestPath bfsShortestPaths = new BFSShortestPaths(new Graph(),"Bercy","HÃ´tel de Ville");

        ShortestPath dijkstraSP=new DijkstraSP(new Graph(),"Bercy","HÃ´tel de Ville");
    }
}
