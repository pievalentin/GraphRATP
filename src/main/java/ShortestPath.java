import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sami- on 03/06/2017.
 */
public abstract class ShortestPath <T>{
    protected Set<Integer> pathSet;
    protected Graph graph;
    protected int s;
    protected int t;
    protected Boolean[] marked;
    protected Integer[] previous;


    public ShortestPath(){
    }

    public ShortestPath(Graph graph, String name,String name2){
        this.graph=graph;
        this.graph=graph;
        this.s=graph.indexOfName(name);
        this.t=graph.indexOfName(name2);

    }

    protected void printResult(){

    }

    public boolean isConnected() {
        return (pathSet.size()==graph.getGraphOrder());
    }

    public int cc() {
        return pathSet.size();
    }

    protected void disp(T[] marked2) {
        for (int i = 0; i < marked2.length; i++) {
            System.out.print(i+":"+marked2[i]+" | ");
        }
        System.out.println();
    }

    protected void print(ArrayList<Integer> pathSet) {
        Iterator<Integer> it = pathSet.iterator();
        while(it.hasNext()){
            System.out.println(graph.getNodes()[it.next()].getNom() + " | ");
        }
    }


    protected ArrayList<Integer> clone(ArrayList<Integer> listToClone) {
        ArrayList<Integer> clone=new ArrayList<>();
        for (int i = 0; i < listToClone.size(); i++) {
            clone.add(listToClone.get(i));
        }
        return clone;
    }
}
