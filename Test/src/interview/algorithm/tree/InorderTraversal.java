package interview.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历,不能用递归
 * Created by chenjianhua on 2014/11/28 0028.
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode curr = root;

        while(!stack.empty() || curr != null){

            // if it is not null, push to stack
            //and go down the tree to left
            if(curr != null){
                stack.push(curr);
                curr = curr.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            }else{
                TreeNode t = stack.pop();
                lst.add(t.val);
                curr = t.right;
            }
        }

        return lst;
    }
}
