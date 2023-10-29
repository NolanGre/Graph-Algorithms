package list_prims_algorithm;

import java.util.List;

public class Prim {

    private List<Vertex> graph;

    public void run() {

        if (!graph.isEmpty()) graph.get(0).setVisited(true);

        while (isDisconnected()){

            Edge nextMin = new Edge(Integer.MAX_VALUE);
            Vertex nextVertex = graph.get(0);

            for (Vertex vertex : graph){

                if (!vertex.isVisited()) continue;

                Pair<Vertex, Edge> candidate = vertex.nextMinimum();

                if (candidate.getValue().getWeight() >= nextMin.getWeight()) continue;

                nextMin = candidate.getValue();
                nextVertex = candidate.getKey();
            }

            nextMin.setIncluded(true);
            nextVertex.setVisited(true);
        }
    }


    private boolean isDisconnected() {

            for (Vertex vertex : graph){

                if (!vertex.isVisited()) return true;
            }
            return false;
        }
}
