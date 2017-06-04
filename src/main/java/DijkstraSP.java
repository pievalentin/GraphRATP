import java.util.*;

/**
 * Created by sami- on 02/06/2017.
 */
public class DijkstraSP extends ShortestPath{


    public DijkstraSP(Graph graph, String name,String name2) {
        super(graph,name,name2);

       // exploreStart(this.s,true);
       // printSP(this.t);
        excentricity();
    }

    void exploreStart(int s,boolean dispResult){
        if (dispResult){
            System.out.println();

            System.out.println("starting point : "+s);
            System.out.println();
        }


            this.marked=new Boolean[graph.getGraphOrder()];//first node is 1 instead of 0
            this.previous=new Integer[graph.getGraphOrder()];
            this.distance=new Double[graph.getGraphOrder()];
            //this.pathSet = new LinkedHashSet<Integer>();

            ArrayList<Integer> stack=new ArrayList<>();
            //int currentDistance=0;
            //int currentPrevious=s;
            //if(pathSet.add(s)){
            stack.add(s);
            marked[s]=true;
            for (int i = 0; i < distance.length; i++) {
                distance[i]=-1.0;
                previous[i]=-1;
                marked[i]=false;
            }
            distance[s]=0.0;
            previous[s]=-1;

            //}
            int interation=0;
            while (!allMarked() ){
                interation++;
               //System.out.println("iteration : "+interation);

                //System.out.println("stack"+stack.toString());
                //currentPrevious=stackbis.get(j);
                //retirer l'élément actif de la liste
                //gets the index of the active element in stack and removes it
                java.util.List<Integer>neighborhood = graph.getAdj()[(stack.get(0))];//get the adjacents of element nb j of stack
                int actifNode=stack.get(0);
                stack.remove(0);
                //System.out.println(graph.getAdj()[0]);
                //System.out.println(neighborhood.toString());
                if (neighborhood !=null) {
                    for (int i = 0; i < neighborhood.size(); i++) {
                        //System.out.println("node : " + neighborhood.get(i) + " used path : " + path.toString()+ " neighborhood "+ neighborhood.toString());
                        //if(pathSet.add(neighborhood.get(i))){
                        int node=neighborhood.get(i);
                        if (notIn(stack, node)){
                            stack.add(node);
                        }

                        marked[node]=true;
                        int previousnode=previous[node];
                        previous[node]=actifNode;
                        if(distance[node]>=0){
                            if(distance[node]<distance[previous[node]]+graph.getDistance(actifNode,neighborhood.get(i))){
                                previous[node]=previousnode;
                            }else {
                                distance[node]=distance[previous[node]]+graph.getDistance(actifNode,neighborhood.get(i));
                            }
                        }else{
                            previous[node]=actifNode;
                            distance[node]=distance[previous[node]]+graph.getDistance(actifNode,neighborhood.get(i));
                        }
                          /* System.out.print("active node : ");
                            System.out.println(node);
                            disp(marked);

                            disp(distance);
                            System.out.println("inifinite is set to -1");
                            disp(previous);
                            System.out.println("stack : " + stack.toString());
                            System.out.println();*/
                    }
                }
            }
        if(dispResult){
            System.out.print("marked : ");disp(marked);
            System.out.print("distances : ");disp(distance);
            System.out.print("previouses : ");disp(previous);
        }
    }

    private boolean allMarked() {
        boolean allMarked=true;
        for (int i = 1; i <marked.length; i++) {
            allMarked=allMarked&&marked[i];
        }
        return allMarked;
    }


    private boolean notIn(ArrayList<Integer> stack, int node) {
        boolean notIn=true;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i)==node){
                notIn=false;
            }
        }
        return notIn;
    }
}
