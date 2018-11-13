import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ANDERSON BALLESTEROS
 */
 
public class Automata {
    private Set<Character> set= new HashSet<>();
    private ArrayList<HashMap<Character, Integer>> dicList = new ArrayList<>(100);
    
    public Automata(String text){
        initializar(text);
    }
    
    public Set getSet(){
        return set;
    }

    public ArrayList<HashMap<Character, Integer>> getDicList() {
        return dicList;
    }

    public void initializar(String text) {
        
        HashMap<Character, Integer> dic = new HashMap<>();
        for (char element : text.toCharArray()) {
            dic.put(element, 0);
            set.add(element);
        }
        Integer terminal = 0;
        dicList.add((HashMap<Character, Integer>)dic.clone());
        for (char element : text.toCharArray()) {
            Character T = element; 
            Integer r = dicList.get(terminal).get(T);
            Integer s = terminal+1;
            dicList.get(terminal).put(T, s);
            dicList.add((HashMap<Character, Integer>)(dicList.get(r).clone()));
            
            terminal++;
        }
    }
}
