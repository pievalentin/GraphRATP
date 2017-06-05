import java.util.ArrayList;
import java.util.LinkedHashSet;


/**
 * Created by sami- on 01/06/2017.
 */
public class BFSShortestPaths extends ShortestPath{


    public BFSShortestPaths(Graph graph, String name,String name2,boolean basic) {
        super(graph,name,name2,basic);
        if(basic){
            //exploreStart(s,true);
            //printSP(this.t,true);
            excentricity(basic);
        }

    }


    void exploreStart(int s,boolean dispResult){//beginning of recurcivity

        if(dispResult){
            System.out.println("starting point : "+s);
        }
        this.marked=new Boolean[graph.getGraphOrder()];
        this.previous=new Integer[graph.getGraphOrder()];
        this.distance=new Double[graph.getGraphOrder()];
        this.pathSet = new LinkedHashSet<Integer>();
        for (int i = 0; i < distance.length; i++) {
            distance[i]=-1.0;
            previous[i]=-1;
            marked[i]=false;
        }

        ArrayList<Integer> stack=new ArrayList<>();
        Double currentDistance=0.0;
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
        if(!basic){
            for (int i = 0; i < distance.length; i++) {
                printSP(i,dispResult);
            }
        }
        if(dispResult){
            System.out.println(this.getClass().toString()+" algorithm path : "+pathSet.toString() );
            System.out.print("marked : ");disp(marked);
            System.out.print("distances : ");disp(distance);
            System.out.print("previouses : ");disp(previous);
        }
    }
}

