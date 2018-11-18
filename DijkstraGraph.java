import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author ANDERSON BALLESTEROS
 */

public class DijkstraGraph {

    private static class Node {

        public String name;
        public Double weight;
        public Node next;

        public Node(String name, Double weight, Node next) {
            this.name = name;
            this.weight = weight;
            this.next = next;
        }

    }
    private final ArrayList<Node> graph;
    private final HashSet<String> nodes;

    public DijkstraGraph(int nodes) {
        graph = new ArrayList<>(nodes);
        this.nodes = new HashSet<>();
    }
    
    public void addNode(String name){
        if (!nodes.contains(name)) {
            graph.add(new Node(name, Double.MAX_VALUE, null));
            nodes.add(name);
        }
    }
    
    public void addArc(String begin, String end, double weight){
        int indexBegin = searhcNode(begin);
        Node Begin = graph.get(indexBegin);
        Node next = Begin.next;
        Begin.next = new Node(end, weight, next);
    }
    
    public void removeArc(String begin, String end){
        int indexBegin = searhcNode(begin);
        Node ant = graph.get(indexBegin);
        Node element = ant.next;
        while (element!=null) {
            if (element.name.equalsIgnoreCase(end)) {
                ant.next = element.next;
                break;
            }
            ant = element;
            element = element.next;
        }
    }
    public void toStrin(){
        for (Node element : graph) {
            System.out.print(element.name+" ->");
            Node next = element.next;
            while (next!=null) {
                System.out.print(" "+next.name);
                next = next.next;
            }
            System.out.println();
        }
    }
    private int searhcNode(String nodeName) {
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).name.equals(nodeName)) {
                return i;
            }
        }
        return -1;
    }

    private int searchMin() {
        int index = 0;
        double min= graph.get(0).weight;
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).weight < min) {
                min = graph.get(i).weight;
                index = i;
            }
        }
        return index;
    }
    
    public ArrayList<ArrayList> dijsktra(String nodeName) {
        ArrayList<ArrayList> toReturn=  new ArrayList(3);
        ArrayList<Double> d = new ArrayList(graph.size());
        ArrayList<String> name = new ArrayList(graph.size()), pi = new ArrayList(graph.size());
        
        HashSet<String> S = new HashSet<>();
        for (int i = 0; i < graph.size(); i++) {
            d.add(Double.MAX_VALUE);
            name.add(graph.get(i).name);
            pi.add(null);
            graph.get(i).weight = Double.MAX_VALUE;
        }
        int u = searhcNode(nodeName);
        d.set(u, 0.0);
        graph.get(u).weight = 0.0;
        for (int i = 0; i < graph.size(); i++) {
            int v = searchMin();
            graph.get(v).weight = Double.MAX_VALUE;
            S.add(graph.get(v).name);
            String father = graph.get(v).name;
            Node element = graph.get(v).next;
            
            while (element != null) {
                int adj = searhcNode(element.name);
                if (d.get(adj) > d.get(v) + element.weight && !S.contains(element.name)) {
                    d.set(adj, d.get(v) + element.weight);
                    graph.get(adj).weight = d.get(adj);
                    pi.set(adj, father);
                }
                element = element.next;
            }
        }
        toReturn.add(name);
        toReturn.add(d);
        toReturn.add(pi);
        return toReturn;
    }

}
