import java.util.*;

public class Dijkstra {

    static private HashSet<Character> visitedVertex = new HashSet<>();
    static private Map<Character, Map<Character, Integer>> graph = new HashMap<>();
    static private Map<Character, Integer> shortestPath = new HashMap<>();

    public static void main(String[] args) {

        createGraph();
        initShortestPath();

        while (visitedVertex.size() != graph.size()) {

            int min = Integer.MAX_VALUE;
            char minVertex = '\0';
            for (Map.Entry<Character, Integer> entry : shortestPath.entrySet()) {

                if (!visitedVertex.contains(entry.getKey()) && entry.getValue() < min) {

                    min = entry.getValue();
                    minVertex = entry.getKey();
                }
            }

            if (minVertex == '\0') {
                System.out.println("End");
                return;
            }

            visitedVertex.add(dijkstra(minVertex));
        }

        System.out.println('\n' + shortestPath.toString());

        findPath('1', '4');
    }

    public static char dijkstra(char vertex) {

        for (Map.Entry<Character, Integer> entry : graph.get(vertex).entrySet()) {

            int min = Math.min(shortestPath.get(entry.getKey()), shortestPath.get(vertex) + entry.getValue());

            if (min != shortestPath.get(entry.getKey())) {

                shortestPath.put(entry.getKey(), min);

            }

        }
        return vertex;
    }

    public static void findPath(char start, char finish) {

        char current = finish;

        System.out.print("\n" + finish + " <- ");
        while (current != start) {

            for (Map.Entry<Character, Map<Character, Integer>> temp : graph.entrySet()) {

                if (!temp.getValue().containsKey(current)) continue;
                if (shortestPath.get(current) - temp.getValue().get(current) == shortestPath.get(temp.getKey())) {

                    System.out.print(temp.getKey() + " <- ");
                    current = temp.getKey();
                    break;
                }
            }
        }

    }

    private static void initShortestPath() {

        shortestPath.put('1', 0);
        shortestPath.put('2', Integer.MAX_VALUE);
        shortestPath.put('3', Integer.MAX_VALUE);
        shortestPath.put('4', Integer.MAX_VALUE);
        shortestPath.put('5', Integer.MAX_VALUE);
        shortestPath.put('6', Integer.MAX_VALUE);
        shortestPath.put('7', Integer.MAX_VALUE);
        shortestPath.put('8', Integer.MAX_VALUE);
    }

    private static void createGraph() {

        graph.put('1', new HashMap<>());
        graph.get('1').put('2', 4);
        graph.get('1').put('3', 1);
        graph.get('1').put('4', 4);

        graph.put('2', new HashMap<>());
        graph.get('2').put('1', 4);
        graph.get('2').put('5', 7);
        graph.get('2').put('6', 3);

        graph.put('3', new HashMap<>());
        graph.get('3').put('1' , 1);
        graph.get('3').put('4' , 5);
        graph.get('3').put('6' , 5);
        graph.get('3').put('8' , 4);

        graph.put('4', new HashMap<>());
        graph.get('4').put('1' , 4);
        graph.get('4').put('3' , 5);
        graph.get('4').put('5' , 1);

        graph.put('5', new HashMap<>());
        graph.get('5').put('2', 7);
        graph.get('5').put('4', 1);
        graph.get('5').put('7', 4);

        graph.put('6', new HashMap<>());
        graph.get('6').put('2', 3);
        graph.get('6').put('3', 5);
        graph.get('6').put('7', 6);

        graph.put('7', new HashMap<>());
        graph.get('7').put('5', 4);
        graph.get('7').put('6', 6);
        graph.get('7').put('8', 5);

        graph.put('8', new HashMap<>());
        graph.get('8').put('3', 4);
        graph.get('8').put('7', 5);
    }
}
