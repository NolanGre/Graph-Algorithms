package list_kruskal;

import java.util.*;

public class Kruskal {
    static Map<String, Integer> mst = new LinkedHashMap<>();
    static Map <Character, Integer> vertex = new HashMap<>();
    static Map<String, Integer> edges = new LinkedHashMap<>();

    public static void main(String[] args) {

        initGraph(edges);
        sortMap(edges);

        System.out.println("Sorted: ");
        printMap(edges);

        for (Map.Entry<String,Integer> entry : edges.entrySet()){

            if (isAcyclic(entry.getKey(), entry.getValue())) {

                mst.put(entry.getKey(), entry.getValue());

                repaint(entry.getKey());
            }
        }

        System.out.println("\nMST: ");
        printMap(mst);

        System.out.println("\nVertex color: " + vertex.toString());
    }

    static void repaint(String edge) {

        char vertex1 = edge.charAt(0);
        char vertex2 = edge.charAt(1);
        int tempColor = vertex.get(vertex2);

        for (char i : vertex.keySet()) {

            if (Objects.equals(vertex.get(i), tempColor)) {

                vertex.put(i, vertex.get(vertex1));
            }
        }
    }

    static boolean isAcyclic(String candidate, int value){

        char vertex1 = candidate.charAt(0);
        char vertex2 = candidate.charAt(1);

        String reverse = String.valueOf(vertex2) + vertex1;

        // Check for undirected edge    uncomment to activate
        //if (mst.containsKey(reverse) && mst.get(reverse) == value) return true;

        // if we have same "color" return false
        return !vertex.get(vertex1).equals(vertex.get(vertex2));
    }

    static void initGraph(Map<String, Integer> edges) {

        // Add vertex and "color" for segregation
        vertex.put('A' , 1);
        vertex.put('B' , 2);
        vertex.put('C' , 3);
        vertex.put('D' , 4);
        vertex.put('E' , 5);
        vertex.put('F' , 6);
        vertex.put('G' , 7);
        vertex.put('H' , 8);

        // Add edges (Vertex 1+Vertex 2, Weight)
        // Can be applied for oriented graph
        edges.put("AB", 4);  // 1, 2
        edges.put("BA", 4);

        edges.put("AC", 1);  // 1, 3
        edges.put("CA", 1);

        edges.put("AD", 4);  // 1, 4
        edges.put("DA", 4);

        edges.put("BE", 7);  // 2, 5
        edges.put("EB", 7);

        edges.put("BF", 3);  // 2, 6
        edges.put("FB", 3);

        edges.put("CD", 5);  // 3, 4
        edges.put("DC", 5);

        edges.put("CF", 5);  // 3, 6
        edges.put("FC", 5);

        edges.put("CH", 4);  // 3, 8
        edges.put("HC", 4);

        edges.put("DE", 1);  // 4, 5
        edges.put("ED", 1);

        edges.put("EG", 4);  // 5, 7
        edges.put("GE", 4);

        edges.put("FG", 6);  // 6, 7
        edges.put("GF", 6);

        edges.put("GH", 5);  // 7, 8
        edges.put("HG", 5);
    }

    static void sortMap(Map<String, Integer> unsortedMap) {

        List<Map.Entry<String, Integer>> list = new ArrayList<>(unsortedMap.entrySet());

        list.sort(Map.Entry.comparingByValue());
        unsortedMap.clear();

        for (Map.Entry<String, Integer> entry : list) {
            unsortedMap.put(entry.getKey(), entry.getValue());
        }
    }

    static void printMap(Map<String, Integer> map) {

        for (String a : map.keySet()) {

            System.out.println("Edge: " + a + "; Weight: " + map.get(a));
        }
    }
}
