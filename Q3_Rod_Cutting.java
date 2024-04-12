package April_12_Assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q3_Rod_Cutting {
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        B.add(0, 0); // Add 0 at the beginning to handle case when there's no cut at the beginning
        B.add(A); // Add A at the end to handle case when there's no cut at the end
        Collections.sort(B); // Sort the cuts
        int n = B.size();

        // dp[i][j] represents the minimum cost of cutting the rod from index i to j
        int[][] dp = new int[n][n];

        // cuts[i][j] represents the index of the cut which results in minimum cost to cut the rod from index i to j
        int[][] cuts = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + B.get(j) - B.get(i);
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        cuts[i][j] = k;
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        constructResult(0, n - 1, cuts, result, B);
        return result;
    }

    private void constructResult(int start, int end, int[][] cuts, ArrayList<Integer> result, ArrayList<Integer> B) {
        if (start + 1 >= end) {
            return;
        }
        int cut = cuts[start][end];
        result.add(B.get(cut));
        constructResult(start, cut, cuts, result, B);
        constructResult(cut, end, cuts, result, B);
    }

    public static void main(String[] args) {
        Q3_Rod_Cutting rodCutting = new Q3_Rod_Cutting();
        int A = 6;
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 5));
        System.out.println(rodCutting.rodCut(A, B)); // Output: [2, 1, 5]
    }
}
