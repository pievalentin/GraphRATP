import com.sun.corba.se.impl.orbutil.graph.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Pierre Valentin on 19/05/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph=new Graph();
        System.out.println(graph.getNodes().length);
        graph.printAdj();
       // ShortestPath bfsShortestPaths = new BFSShortestPaths(new Graph(),"Bercy","HÃ´tel de Ville");
        ShortestPath dijkstraSP=new DijkstraSP(new Graph(),"1","5");
    }
}
