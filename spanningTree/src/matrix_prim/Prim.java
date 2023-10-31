package matrix_prim;

public class Prim {
    public static void main(String[] args) {

        int inf = Integer.MAX_VALUE;  // for edge that not exist

        int[] A = {inf, 5,   10,  inf, 2};
        int[] B = {5,   inf, inf, 1,   inf};
        int[] C = {10,  inf, inf, 6,   4};
        int[] D = {inf, 1,   6,   inf, inf};
        int[] E = {2,   inf, 4,   inf, inf};

        int[][] initialMatrix ={A, B, C, D, E};

        System.out.println("Initial matrix: " + stringArr(initialMatrix));
        System.out.println("MST matrix: " + stringArr(mst(initialMatrix)));
    }

    public static int[][] mst(int[][] initMatrix) {

        int n = initMatrix.length;
        int[][] mstMatrix = new int[n][n];
        boolean[] isCompleted = new boolean[n];

        isCompleted[0] = true;  // set first vertex as included

        //System.out.println(boolPrint(isCompleted));

        while (!checkComp(isCompleted)) {

            int minI = Integer.MAX_VALUE;
            int minJ = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {

                if (!isCompleted[i]) continue;

                if (minJ == Integer.MAX_VALUE) {

                    minI = i;
                    minJ = i;
                }

                //System.out.println("take vertex: " + i);

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

            // mirror write for notOriented grap
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
