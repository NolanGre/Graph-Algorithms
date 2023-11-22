public class FloydWarshall {

    private static int[][] distanceMatrix;
    public static void main(String[] args) {

        int m = Integer.MAX_VALUE;
        distanceMatrix = new int[][] {
                {0, m, 2, 4, m, 8, m, m},
                {m, 0, m, 6, 7, 6, m, m},
                {2, m, 0, 5, m, 5, m, 4},
                {4, m, 5, 0, 1, m, m, m},
                {m, 7, m, 1, 0, m, 4, m},
                {8, 6, 3, m, m, 0, 6, m},
                {m, m, m, m, 4, 5, m, m},
                {m, m, 4, m, m, 5, m, 0}
        };

        System.out.println("Size: " + distanceMatrix.length);
        printMatrix(distanceMatrix);

        for (int k = 0; k < distanceMatrix.length; k++) {
            System.out.println("k: " + k + 1);
            for (int i = 0; i < distanceMatrix.length; i++) {
                for (int j = 0; j < distanceMatrix.length; j++) {

                    if (distanceMatrix[i][k] == m || distanceMatrix[k][j] == m) continue;
                    if (distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {

                        System.out.println("i: " + i + 1 + ", j: " + j + 1 + " " +
                                "min(" + distanceMatrix[i][j] + ", (" + distanceMatrix[i][k] + " + " + distanceMatrix[k][j] + "))" +
                                " = " + (distanceMatrix[i][k] + distanceMatrix[k][j]));

                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                    }
                }
            }
            printMatrix(distanceMatrix);
        }
    }

    public static void printMatrix(int[][] arr) {

        System.out.println("\n\t0\t1\t2\t3\t4\t5\t6\t7");
        int count = 0;
        for (int[] i : arr) {
            System.out.print(count++);
            for (int j : i) {
                System.out.print(j == Integer.MAX_VALUE ? "\tm" : "\t" + j);
            }
            System.out.println();
        }
    }
}
