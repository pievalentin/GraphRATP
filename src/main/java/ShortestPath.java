import java.util.*;

/**
 * Created by sami- on 03/06/2017.
 */
public abstract class ShortestPath {
    protected Set<Integer> pathSet;
    protected Graph graph;
    protected int s;
    protected int t;
    protected Boolean[] marked;
    protected Integer[] previous;
    protected Double[] distance;
    protected Double[] excentricity;
    protected List<Integer>[]nodesBetweenness;
    protected boolean basic;

    public ShortestPath(){
    }

    public ShortestPath(Graph graph, String name,String name2,boolean basic){
        this.basic=basic;
        this.graph=graph;
        this.graph=graph;
        this.s=graph.indexOfName(name);
        this.t=graph.indexOfName(name2);
        int iteration=0;
        if(!basic){
            do{
                System.out.println();
                System.out.print("iteration : "+(iteration++));
                createNodesBetweenness();
                excentricity(basic);
                //dispNodesBetweenness();
                System.out.println("size of sub Graph : "+sizeSubGraph());
                removeNodeBetweenness();


            }while (sizeSubGraph()>1);
        }

    }
    protected void excentricity(boolean basic){
        System.out.println();
        excentricity=new Double[graph.getGraphOrder()];
        for (int i = 0; i < excentricity.length; i++) {
            exploreStart(i,false);
            excentricity[i]=maxValue(distance);
        }
        System.out.print("excentricity of each vertex : ");disp(excentricity);
        System.out.println("diameter : "+ maxValue(excentricity));
        System.out.println("radius : "+minValue(excentricity));
        if(basic){
            exploreStart(Arrays.asList(excentricity).indexOf(maxValue(excentricity)),true);
            printSP(Arrays.asList(distance).indexOf(maxValue(distance)),true);
        }

    }

    abstract void exploreStart(int s,boolean dispResult);

    protected void printResult(){

    }

    public boolean isConnected() {
        return (pathSet.size()==graph.getGraphOrder());
    }

    public int cc() {
        return pathSet.size();
    }

    protected <T>void disp(T[] marked2) {
        for (int i = 0; i < marked2.length; i++) {
            System.out.print(i+":"+marked2[i]+" | ");
        }
        System.out.println();
    }

    protected void printSP(int v,boolean display) {
        ArrayList<Integer> path=new ArrayList<>();
        path.add(v);
        if (marked[v] && previous[v]>0){//todo check && marked[v]
            path.add(0,previous[v]);
            printSPbis(previous[v],path);
        }
        if(display){
            System.out.println(path.toString());
            System.out.println(graph.getNodes()[path.get(0)].getNom());
            for (int i = 1; i <path.size(); i++) {
                System.out.print(graph.getNodes()[path.get(i)].getNom());
                if(this.getClass()==DijkstraSP.class){
                    System.out.println( "\t \t  \t \t distance from previous : "+graph.getDistance(path.get(i-1),path.get(i)));
                }else {
                    System.out.println();
                }
            }
        }else {
            fillNodesBetweenness(path);
        }

    }

    protected void printSPbis(int v, ArrayList<Integer>path) {
        if (previous[v]>0){
            path.add(0,previous[v]);
            printSPbis(previous[v],path);
        }
    }

    protected void createNodesBetweenness(){
        nodesBetweenness=new ArrayList[graph.getAdj().length];;
        for (int i = 0; i <graph.getAdj().length; i++) {
            nodesBetweenness[i]=new ArrayList<>();
            for (int j = 0; j <graph.getAdj()[i].size(); j++) {
                nodesBetweenness[i].add(0);
            }
        }
    }
    protected void fillNodesBetweenness(ArrayList<Integer> path){
        for (int i = 1; i <path.size(); i++) {
            try {
                nodesBetweenness[path.get(i-1)].set(graph.getAdj()[path.get(i-1)].indexOf(path.get(i))  ,
                        nodesBetweenness[path.get(i-1)].get(graph.getAdj()[path.get(i-1)].indexOf(path.get(i)))+1);
                nodesBetweenness[path.get(i)].set(graph.getAdj()[path.get(i)].indexOf(path.get(i-1))  ,
                        nodesBetweenness[path.get(i)].get(graph.getAdj()[path.get(i)].indexOf(path.get(i-1)))+1);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    protected void removeNodeBetweenness() {
        int maxArray=0;
        int maxList=0;
        for (int i = 0; i <nodesBetweenness.length; i++) {
            for (int j = 0; j < nodesBetweenness[i].size(); j++) {
                if(nodesBetweenness[maxArray].get(maxList)<nodesBetweenness[i].get(j)){
                    maxArray=i;
                    maxList=j;
                }
            }
        }
        graph.remove(maxArray,maxList);
    }

    protected void dispNodesBetweenness(){
        int maxValue=0;
        int maxIndex=0;
        int nb5000=0;
        int[] repartition=new int[23000];
        String nodesBeteweeness="";
        for (int i = 0; i < repartition.length; i++) {
            repartition[i]=0;
        }
        for (int i = 0; i <nodesBetweenness.length; i++) {
            System.out.println();
            if(maxValue<Collections.max(nodesBetweenness[i])){
                maxIndex=i;
                maxValue=Collections.max(nodesBetweenness[i]);
            }
            System.out.print(i+" : "+nodesBetweenness[i].toString());
            for (int j = 0; j < nodesBetweenness[i].size(); j++) {
                if(nodesBetweenness[i].get(j)>9000){
                    nb5000++;
                    nodesBeteweeness+=nodesBetweenness[i].get(j)+" : "+graph.getNodes()[i].getNom()+" <-> "+ graph.getNodes()[graph.getAdj()[i].get(j)].getNom()+"\n";
                }
                repartition[nodesBetweenness[i].get(j)]=repartition[nodesBetweenness[i].get(j)]+1;
            }
        }
        System.out.println(maxIndex + " : "+ maxValue);
        System.out.println("nb5000 : "+nb5000);
        int somme=0;
        int sommetotale=0;
        for (int i = 0; i <60; i++) {
            somme=0;
            System.out.print(i*200+" : \t");
            for (int j = 0; j < 200; j++) {
                for (int k = 0; k < repartition[i*200+j]; k++) {
                    System.out.print("-");
                    somme++;
                    sommetotale++;
                }
            }
            System.out.print(somme);
            System.out.println();
        }
        System.out.println(sommetotale);
        System.out.println(nodesBeteweeness);
    }

    protected void print(ArrayList<Integer> pathSet) {
        Iterator<Integer> it = pathSet.iterator();
        while(it.hasNext()){
            System.out.println(graph.getNodes()[it.next()].getNom() + " | ");
        }
    }
    protected static double maxValue(Double[] distance2) {
        double max = distance2[0];
        for (int i = 0; i < distance2.length; i++) {
            if (distance2[i] > max) {
                max = distance2[i];
            }
        }
        return max;
    }

    protected static double minValue(Double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    protected ArrayList<Integer> clone(ArrayList<Integer> listToClone) {
        ArrayList<Integer> clone=new ArrayList<>();
        for (int i = 0; i < listToClone.size(); i++) {
            clone.add(listToClone.get(i));
        }
        return clone;
    }

    public int sizeSubGraph(){
        int sizeSubGraph=0;
        for (int i = 0; i < marked.length; i++) {
            if(marked[i]){
                sizeSubGraph++;
            }
        }return sizeSubGraph;
    }

    public boolean haspathTo(int v){
        return marked[v];
    }
    public double  distTo(int v) {
        return distance[v];
    }
}
