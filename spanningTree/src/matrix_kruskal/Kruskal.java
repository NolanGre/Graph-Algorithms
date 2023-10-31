package matrix_kruskal;

import java.util.HashMap;
import java.util.Map;

public class Kruskal {
    public static void main(String[] args) {

        //TODO: write Kruskal for matrix

        int inf = Integer.MAX_VALUE;  // for edge that not exist

        int[] A = {inf, 5,   10,  inf, 2};
        int[] B = {5,   inf, inf, 1,   inf};
        int[] C = {10,  inf, inf, 6,   4};
        int[] D = {inf, 1,   6,   inf, inf};
        int[] E = {2,   inf, 4,   inf, inf};

        int[][] matrix = {A, B, C, D, E};
        int n = matrix.length;

        Map<String, Integer> edges = new HashMap<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; i++){

                if (matrix[i][j] == inf) continue;

                //edges.put()
            }
        }


    }

}
