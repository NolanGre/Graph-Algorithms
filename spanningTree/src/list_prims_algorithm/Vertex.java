package list_prims_algorithm;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private String label = null;
    private Map<Vertex, Edge> edges = new HashMap<>();
    private boolean isVisited = false;

    public Vertex(String label) {
        this.label = label;
    }

    public Pair<Vertex, Edge> nextMinimum() {

        Edge nextMin = new Edge(Integer.MAX_VALUE);
        Vertex nextVertex = this;

        for (Map.Entry<Vertex, Edge> pair : edges.entrySet()) {

            if (pair.getKey().isVisited()) continue;
            if (pair.getValue().isIncluded()) continue;
            if (pair.getValue().getWeight() < nextMin.getWeight()) {

                nextMin = pair.getValue();
                nextVertex = pair.getKey();
            }
        }
        return new Pair<>(nextVertex, nextMin);
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<Vertex, Edge> getEdges() {
        return edges;
    }

    public void setEdges(Map<Vertex, Edge> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
