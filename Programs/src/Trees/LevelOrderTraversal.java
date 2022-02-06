package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    // Definition for binary tree
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }
      }


      //Approach -1
    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
    static int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    static List<Integer> printCurrentLevel(TreeNode root, int level){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        if(level == 1){
            System.out.print(root.val);
            list.add(root.val);
            System.out.print(" ");
        }
        else{
            list.addAll(printCurrentLevel(root.left,level-1));
            list.addAll(printCurrentLevel(root.right,level-1));
            System.out.println("");
        }
        return list;
    }


      static class BinaryTree{
          TreeNode root;
          public BinaryTree() { root = null; }

          int[][] printLevelOrder(){
              int h = height(root);
              int[][] resArr = new int[h][1];
              for(int i=1 ; i<=h; i++){
                  List<Integer> list = printCurrentLevel(root,i);
                  int[] res = new int[list.size()];
                  for(int j=0;j<list.size(); j++){
                      res[j] = list.get(j);
                  }
                  resArr[i-1] = res;
              }
              return resArr;
          }
      }

      //Approach-2: Using Queues


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        int[][] result = tree.printLevelOrder();
        System.out.println(result);
    }

}
