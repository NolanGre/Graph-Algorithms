package matrix_prim;

public class Prim {
    public static void main(String[] args) {

        int f = Integer.MAX_VALUE;  // for edge what not exist

        int[] A = {f, 4, 1, 4, f, f, f, f};
        int[] B = {4, f, f, f, 7, 3, f, f};
        int[] C = {1, f, f, 5, f, 5, f, 4};
        int[] D = {4, f, 5, f, 1, f, f, f};
        int[] E = {f, 7, f, 1, f, f, 4, f};
        int[] F = {f, 3, 5, f, f, f, 6, f};
        int[] G = {f, f, f, f, 4, 6, f, 5};
        int[] H = {f, f, 4, f, f, f, 5, f};

        // rename vertex (from 1,2,3... to A,B,C...)
        int[][] initialMatrix ={A, B, C, D, E, F, G, H};

        System.out.println("Initial matrix: " + stringArr(initialMatrix));
        System.out.println("MST matrix: " + stringArr(mst(initialMatrix)));
    }

    public static int[][] mst(int[][] initMatrix) {

        int n = initMatrix.length;
        int[][] mstMatrix = new int[n][n];
        boolean[] isCompleted = new boolean[n];

        isCompleted[0] = true;  // set first vertex as included

        while (!checkComp(isCompleted)) {

            int minI = Integer.MAX_VALUE;
            int minJ = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {

                if (!isCompleted[i]) continue;

                if (minJ == Integer.MAX_VALUE) {

                    minI = i;
                    minJ = i;
                }

                for (int j = 0; j < n; j++) {

                    if (i == j) continue;
                    if (initMatrix[i][j] == mstMatrix[i][j]) continue;

                    if (initMatrix[i][j] < initMatrix[minI][minJ]){

                        minI = i;
                        minJ = j;
                    }
                }
            }

            if (initMatrix[minI][minJ] == Integer.MAX_VALUE) continue;
            isCompleted[minJ] = true;
            mstMatrix[minI][minJ] = initMatrix[minI][minJ];

            // mirror write for notOriented graph
            mstMatrix[minJ][minI] = initMatrix[minI][minJ];

        }

        return mstMatrix;
    }

    public static boolean checkComp(boolean[] arr){

        for (boolean i : arr)
            if (!i)
                return false;

        return true;
    }


    public static String stringArr(int[][] arr) {

        String res = "\n";
        for (int[] i : arr) {
            for (int j : i){

                if (j != Integer.MAX_VALUE) res += j + "\t";
                else res += "inf\t";
            }
            res += "\n";
        }
        return res;
    }

    public static String boolPrint(boolean[] arr) {

        String res = "";
        for (boolean i : arr) res += i + "\t";
        return res;
    }
}
