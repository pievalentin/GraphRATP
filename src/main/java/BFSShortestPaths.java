import java.awt.DisplayMode;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by sami- on 01/06/2017.
 */
public class BFSShortestPaths extends ShortestPath{


    private Integer[] distance;
    private Integer[] excentricity;

    public BFSShortestPaths(Graph graph, String name,String name2) {//todo remplacer variable s par this.s
        super(graph,name,name2);

        //exploreStart(s);
        excentricity();
    }


    private void exploreStart(int s){//beginning of recurcivity
        System.out.println("starting point : "+s);
        this.marked=new Boolean[graph.getGraphOrder()];
        this.previous=new Integer[graph.getGraphOrder()];
        this.distance=new Integer[graph.getGraphOrder()];
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

        System.out.println(this.getClass().toString()+" algorithm path : "+pathSet.toString() );
        System.out.print("marked : ");disp(marked);
        System.out.print("distances : ");disp(distance);
        System.out.print("previouses : ");disp(previous);

    }



    private void excentricity(){
        excentricity=new Integer[graph.getGraphOrder()];
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

    private static int maxValue(Integer[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int minValue(Integer[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }




}

