//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
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
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 365 👎 0


package leetcode.editor.cn.mainThread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的序列化与反序列化
//2020-09-28 22:12:37
public class P297SerializeAndDeserializeBinaryTree {

    @Test
    public void testResult() {
        //TO TEST
        Codec codec = new Codec();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";
            List<String> list = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll == null) {
                        list.add("null");
                        continue;
                    }
                    list.add(String.valueOf(poll.val));
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            while (list.listIterator().next().equals("null")) {
                list.listIterator().remove();
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String s : list) {
                sb.append(s).append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) return null;
            String substring = data.substring(1, data.length() - 1);
            if (substring.length() == 0) return null;
            String[] nodes = substring.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (index >= nodes.length || "null".equals(nodes[index])) {
                        poll.left = null;
                        index++;
                    } else {
                        poll.left = new TreeNode(Integer.parseInt(nodes[index++]));
                        queue.offer(poll.left);
                    }
                    if (index >= nodes.length || "null".equals(nodes[index])) {
                        index++;
                        poll.right = null;
                    } else {
                        poll.right = new TreeNode(Integer.parseInt(nodes[index++]));
                        queue.offer(poll.right);
                    }
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}