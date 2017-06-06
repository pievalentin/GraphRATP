import java.io.IOException;

/**
 * Created by Pierre Valentin on 19/05/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph=new Graph();
        System.out.println(graph.getNodes().length);
        graph.printAdj();
        /*
         *basic:
          *  true : ex3;
          *  false : ex4 // choose only one algorithm for ex 4
         */

        //exe 3 | l'affichage du chemin entre deux point est désactivé, il correspond aux lignes 31 et 32 de ShortestPath.
        ShortestPath bfsShortestPaths = new BFSShortestPaths(new Graph(),"Bercy","Hôtel de Ville",true);
        ShortestPath dijkstraSP=new DijkstraSP(new Graph(),"Bercy","Hôtel de Ville",true  );

        //ex4 : select only one of both algorithm
        //ShortestPath bfsShortestPaths = new BFSShortestPaths(new Graph(),"Bercy","Hôtel de Ville",false);
        //ShortestPath dijkstraSP=new DijkstraSP(new Graph(),"Bercy","Hôtel de Ville",false  );
    }
}
