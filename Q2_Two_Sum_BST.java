package April_12_Assignment;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class Q2_Two_Sum_BST {
    public int t2Sum(TreeNode A, int B) {
        Set<Integer> set = new HashSet<>();
        return t2SumUtil(A, B, set) ? 1 : 0;
    }

    private boolean t2SumUtil(TreeNode node, int B, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(B - node.val)) {
            return true;
        }
        set.add(node.val);
        return t2SumUtil(node.left, B, set) || t2SumUtil(node.right, B, set);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);

        Q2_Two_Sum_BST solution = new Q2_Two_Sum_BST();
        System.out.println(solution.t2Sum(root1, 19)); // Output: 1

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);

        System.out.println(solution.t2Sum(root2, 40)); // Output: 0
    }
}
