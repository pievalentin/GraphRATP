import java.awt.DisplayMode;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sami- on 01/06/2017.
 */
public class BFSShortestPaths {
    private Graph graph;
    private Set<Integer> pathSet;
    private int s;
    private int t;

    private boolean[] marked;
    private int[] previous;
    private int[] distance;
    private int[] excentricity;


    public BFSShortestPaths(Graph graph, String name,String name2) {//todo remplacer variable s par this.s
        this.graph=graph;
        this.s=graph.indexOfName(name);
        this.t=graph.indexOfName(name2);

        exploreStart(s);
        //excentricity();
    }

    private void exploreStart(int s){//beginning of recurcivity
        System.out.println("starting point : "+s);
        this.marked=new boolean[graph.getGraphOrder()];
        this.previous=new int[graph.getGraphOrder()];
        this.distance=new int[graph.getGraphOrder()];
        this.pathSet = new LinkedHashSet<Integer>();

        ArrayList<Integer> stack=new ArrayList<>();
        int currentDistance=0;
        int currentPrevious=s;
        if(pathSet.add(s)){
            stack.add(s);
            marked[s]=true;
            distance[s]=currentDistance;
            previous[s]=-1;

        }
        while (!stack.isEmpty()){
            ArrayList<Integer> stackbis=clone(stack);
            currentDistance++;
            for (int j = 0; j < stackbis.size(); j++) {
                //System.out.println("stack"+stack.toString());
                currentPrevious=stackbis.get(j);
                stack.remove(stack.indexOf(stackbis.get(j)));//retirer l'élément actif de la liste
                //gets the index of the active element in stack and removes it
                //java.util.List<Integer>neighborhood = graph.neighbors(stackbis.get(j));
                java.util.List<Integer>neighborhood = graph.getAdj()[stackbis.get(j)];
                if (neighborhood !=null) {
                    for (int i = 0; i < neighborhood.size(); i++) {
                        //System.out.println("node : " + neighborhood.get(i) + " used path : " + path.toString()+ " neighborhood "+ neighborhood.toString());
                        if(pathSet.add(neighborhood.get(i))){
                            int node=neighborhood.get(i);
                            stack.add(node);
                            marked[node]=true;
                            distance[node]=currentDistance;
                            previous[node]=currentPrevious;
                        }
                    }
                }
            }
        }

        System.out.println("bfs algorithm path : "+pathSet.toString() );
        System.out.println("bfs algorithm path : " ); //print(pathSet);
        System.out.print("marked : ");disp(marked);
        System.out.print("distances : ");disp(distance);
        System.out.print("previouses : ");disp(previous);
        System.out.print("shortest path to 0 : ");printSP(t);
    }

    private void print(Set<Integer> pathSet) {
        Iterator<Integer> it = pathSet.iterator();
        while(it.hasNext()){
            System.out.println(graph.getNodes()[it.next()].getNom() + " | ");
        }
    }

    private void print(ArrayList<Integer> pathSet) {
        Iterator<Integer> it = pathSet.iterator();
        while(it.hasNext()){
            System.out.println(graph.getNodes()[it.next()].getNom() + " | ");
        }
    }

    private void excentricity(){
        excentricity=new int[graph.getGraphOrder()];
        for (int i = 0; i < excentricity.length; i++) {
            exploreStart(i);
            excentricity[i]=maxValue(distance);
            System.out.println();
        }
        System.out.print("excentricity of each vertex : ");disp(excentricity);
        System.out.println("diameter : "+ maxValue(excentricity));
        System.out.println("radius : "+minValue(excentricity));

    }

    public boolean haspathTo(int v){
        return marked[v];
    }
    public int  distTo(int v) {
        return distance[v];
    }

    public void printSP(int v) {
        ArrayList<Integer> path=new ArrayList<Integer>();
        path.add(v);
        if (previous[v]>0){//if (previous[v]>0){
            path.add(0,previous[v]);
            printSPbis(previous[v],path);
        }
        System.out.println(path.toString());
        print(path);
    }

    public void printSPbis(int v, ArrayList<Integer>path) {
        if (previous[v]>0){//if (previous[v]>0){
            path.add(0,previous[v]);
            printSPbis(previous[v],path);
        }

    }

    private static int maxValue(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int minValue(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private void disp(boolean[] marked2) {
        for (int i = 0; i < marked2.length; i++) {
            System.out.print(i+":"+marked2[i]+" | ");
        }
        System.out.println();
    }

    private void disp(int[] distance2) {
        for (int i = 0; i < distance2.length; i++) {
            System.out.print(i+":"+distance2[i]+" | ");
        }
        System.out.println();
    }

    private ArrayList<Integer> clone(ArrayList<Integer> listToClone) {
        ArrayList<Integer> clone=new ArrayList<>();
        for (int i = 0; i < listToClone.size(); i++) {
            clone.add(listToClone.get(i));
        }
        return clone;
    }


    public boolean isConnected() {
        return (pathSet.size()==graph.getGraphOrder());
    }

    public int cc() {
        return pathSet.size();
    }
}

