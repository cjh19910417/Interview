package interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历,不能用递归
 * Created by Jian on 14/11/27.
 */
public class PostorderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;

        System.out.println("PostorderTraversal = " + new PostorderTraversal().postorderTraversal(root));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while(!stack.empty()){//判断是否为空,栈为空的话,说明任务都完成了
            TreeNode curr = stack.peek();

            // 向下走
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){//检查当前节点是否为上个节点的左右叶,如果是,代表为向下走
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from left node
                //need to check if there is a right child
                //if yes, push it to stack
                //otherwise, process parent and pop stack
            }else if(curr.left == prev){//向上走,判断是从左边叶,向上(说明当前节点的left leaf已经被处理过了)
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from right node
                //after coming back from right node, process parent node and pop stack.
            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.val);
            }

            prev = curr;
        }

        return lst;
    }

}
