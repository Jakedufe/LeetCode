//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 59 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
//Java：序列化二叉树
public class P剑指_offer_37XuLieHuaErChaShuLcof{
    
    @Test
    public void testResult() {
//        Solution solution = new P剑指_offer_37XuLieHuaErChaShuLcof().new Solution();        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null) {
                sb.append(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            }
            else sb.append("null ");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;
        String[] elements = data.split(" ");
        if("null".equals(elements[0])) return null;
        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!elements[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(elements[i]));
                queue.add(node.left);
            }
            i++;
            if(!elements[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(elements[i]));
                queue.add(node.right);
            }
            i++;

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}