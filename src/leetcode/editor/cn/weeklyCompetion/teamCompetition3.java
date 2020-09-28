package leetcode.editor.cn.weeklyCompetion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：周赛
//2020-09-19 15:09:18
public class teamCompetition3 {

    @Test
    public void testResult() {
        //TO TEST


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TreeNode {
        String name;
        List<TreeNode> children;
        boolean isAlive;

        TreeNode(String name) {
            this.name = name;
            isAlive = true;
            children = new ArrayList<>();
        }
    }

    class ThroneInheritance {
        TreeNode king;
        List<String> res;
        boolean isChanged;
        Map<String, TreeNode> hashMap;

        public ThroneInheritance(String kingName) {
            king = new TreeNode(kingName);
            res = new ArrayList<>();
            hashMap = new HashMap<>();
            isChanged = true;
            hashMap.put(kingName, king);
        }

        public void birth(String parentName, String childName) {
            TreeNode parent = hashMap.get(parentName);
            if (parent.children == null) {
                parent.children = new ArrayList<>();
            }
            parent.children.add(new TreeNode(childName));
            isChanged = true;
        }


        public void death(String name) {
            TreeNode treeNode = hashMap.get(name);
            isChanged = true;
            treeNode.isAlive = false;
        }

        public List<String> getInheritanceOrder() {
            if (!isChanged) return res;
            else {
                isChanged = false;
                res.clear();
                preOrder(king);
                return res;
            }
        }

        private void preOrder(TreeNode root) {
            if (root == null) return;
            if (root.isAlive) res.add(root.name);
            for (TreeNode child : root.children) {
                preOrder(child);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}