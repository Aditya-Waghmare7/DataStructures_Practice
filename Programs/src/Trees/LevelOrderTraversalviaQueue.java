package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalviaQueue {

    static class TreeNode {
        int val;
        LevelOrderTraversalviaQueue.TreeNode left;
        LevelOrderTraversalviaQueue.TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    static class BinaryTree {
        TreeNode root;
        public BinaryTree() {
            root = null;
        }

        void printLevelOrder() {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode tempNode = queue.poll();
                System.out.print(tempNode.val+ " ");
                //Enqueue Left Child
                if(tempNode.left != null){
                    queue.add(tempNode.left);
                }
                //Enqueue Right Child
                if(tempNode.right != null){
                    queue.add(tempNode.right);
                }
                System.out.println("");
            }
        }
    }
    public static void main(String[] args) {
        LevelOrderTraversalviaQueue.BinaryTree tree = new LevelOrderTraversalviaQueue.BinaryTree();
        tree.root = new LevelOrderTraversalviaQueue.TreeNode(1);
        tree.root.left = new LevelOrderTraversalviaQueue.TreeNode(2);
        tree.root.right = new LevelOrderTraversalviaQueue.TreeNode(3);
        tree.root.left.left = new LevelOrderTraversalviaQueue.TreeNode(4);
        tree.root.left.right = new LevelOrderTraversalviaQueue.TreeNode(5);

        //int[][] result =
                tree.printLevelOrder();
        //System.out.println(result);
    }
}
