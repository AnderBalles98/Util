import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author ANDERSON BALLESTEROS
 */
 
public final class Automata {
    private final Set<Character> set= new HashSet<>();
    private final ArrayList<LinkedHashMap<Character, Integer>> dicList = new ArrayList<>(100);
    
    public Automata(String text){
        initialize(text);
    }
    
    public Set getSet(){
        return set;
    }

    public ArrayList<LinkedHashMap<Character, Integer>> getDicList() {
        return dicList;
    }

    private void initialize(String text) {
        
        LinkedHashMap<Character, Integer> dic = new LinkedHashMap<>();
        for (char element : text.toCharArray()) {
            dic.put(element, 0);
            set.add(element);
        }
        
        Integer terminal = 0;
        dicList.add((LinkedHashMap<Character, Integer>)dic.clone());
        
        for (char element : text.toCharArray()) {
            Character T = element; 
            Integer r = dicList.get(terminal).get(T);
            Integer s = terminal+1;
            dicList.get(terminal).put(T, s);
            dicList.add((LinkedHashMap<Character, Integer>)(dicList.get(r).clone()));
            terminal++;
        }
    }
}
