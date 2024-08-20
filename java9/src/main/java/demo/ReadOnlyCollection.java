package demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadOnlyCollection {

    public static void main(String[] args) {
        List<String> readOnlyList = List.of("a", "b", "c", "d");
        System.out.println(readOnlyList);
        Set<String> readOnlySet = Set.of("a", "b", "c", "d");
        System.out.println(readOnlySet);
        Map<String, String> readOnlyMap = Map.of("key1", "val1", "key2", "val2");
        System.out.println(readOnlyMap);

        try {
            readOnlyList.add("e");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
