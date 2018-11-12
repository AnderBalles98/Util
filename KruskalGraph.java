import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author ANDERSON BALLESTEROS RODRIGUEZ
 */
 
public class Kruskal {
    
    private ArrayList<Arco> arcos = new ArrayList<>(100000);
    private LinkedList<Set<String>> nodeList = new LinkedList<>();
    private ArrayList<Arco> arcosReturn = new ArrayList<>(100000);
    private Integer size=0;
    
    private class Arco implements Comparable<Arco> {

        public Integer weigh;
        public String nodeA;
        public String nodeB;

        public Arco(Integer weigh, String nodeA, String nodeB) {
            this.weigh = weigh;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Arco o) {
            return weigh.compareTo(o.weigh);
        }

    }
    
    public void addArco(Integer weigh, String nodeA, String nodeB){
        arcos.add(new Arco(weigh, nodeA, nodeB));
    }
    
    public void addNode(String node){
        Set<String> set = new HashSet();
        set.add(node);
        if (!nodeList.contains(set)) {
            nodeList.add(set);
        }
    }

    public ArrayList<Arco> getArcosReturn() {
        return arcosReturn;
    }

    public Integer getSize() {
        return size;
    }
    
    private Boolean unir(Arco arco) {
        Set a = null;
        Set b = null;
        for (int i = 0; i < nodeList.size(); i++) {
            Set set = nodeList.get(i);
            if (set.contains(arco.nodeA)) {
                a = set;
                if (set.contains(arco.nodeB)) {
                    return false;
                }
            } else if (set.contains(arco.nodeB)) {
                b = set;
                if (set.contains(arco.nodeA)) {
                    return false;
                }
            }
            if (a != null && b != null) {
                nodeList.remove(a);
                nodeList.remove(b);
                a.addAll(b);
                nodeList.add(a);
                return true;
            }

        }
        return false;
    }

    public void kruskal() {
        Collections.sort(arcos);
        Integer index = 0;
        while (nodeList.size() != 1 && index < arcos.size()) {
            if (unir(arcos.get(index))) {
                arcosReturn.add(arcos.get(index));
                size += (arcos.get(index).weigh);
            }
            index++;
        }
    }

}
