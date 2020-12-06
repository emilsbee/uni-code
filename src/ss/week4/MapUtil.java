package ss.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.lang.model.element.Element;

public class MapUtil {

    /** 
     *@return whether the map is an injection or not 
    */
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {     
        // Compares the amount of unique values to the amount of total keys.
        // If the amount is the same, it means each key has exactly one value, hence OneOnOne   
        return map.values().stream().distinct().count() == map.keySet().size(); 
    }
    
    /**
     * 
     * @return whether the map is surjective on a specific range
     */
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        // Checks whether each value in range is also present in map.
        return range.stream().allMatch(e -> map.containsValue(e));
    }
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map <V, Set<K>> newMap = new HashMap<V, Set<K>>(); // The inversed map
        
        for (Map.Entry<K, V> entry : map.entrySet()) { // Iterates over entries of map
            Set<K> keyList = new HashSet<>(); // List of keys for duplicate values
        
            for (Map.Entry<K, V> subEntry : map.entrySet()) { // Iterates over entries of map
                if (entry.getValue().equals(subEntry.getValue())) { // When the value from outer loop matches a value from this loop
                    keyList.add(subEntry.getKey()); // Add the value's key to current list of keys
                }
            }
            
            if (!newMap.containsKey(entry.getValue())) { // Checks that the new map doesn't already contain an entry with the key being outer loop's value
                newMap.put(entry.getValue(),keyList); // Adds new entry o to inversed map with key being a value from map and the value being a list of keys for duplicate values
            }
        }

        return newMap;
    }
    
    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        if (MapUtil.isOneOnOne(map)) { // If the map is OneOnOne
            Map <V, K> newMap = new HashMap<>(); // The inversed map

            for (Map.Entry<K, V> entry : map.entrySet()) { // Iterates over map entries
                newMap.put(entry.getValue(), entry.getKey()); // Creates new entry to newMap with key being the value from map entry and value being key from map entry
            }
            
            return newMap;
        } else return null; 
    }
	
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        return f.values().stream().allMatch(e -> g.keySet().contains(e)); // Checks that each value from f is a key in g
    }
	
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        if (MapUtil.compatible(f, g)) { // If maps are compatible
            Map<K, W> newMap = new HashMap<>(); // The new composed map

            for (Map.Entry<K, V> entry : f.entrySet()) { // Iterates over map f
                
                for(Map.Entry<V, W> subEntry : g.entrySet()) { // Iterates over map g
                    if (entry.getValue().equals(subEntry.getKey())) { // If the value from map f is equal to one of the keys in map g
                        newMap.put(entry.getKey(), subEntry.getValue()); 
                    }
                }
            }
            return newMap;
        }
        return null;
    }
	
}
