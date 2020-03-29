import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: TestBinaryTree
 * @Description: TODO 二叉树测试
 * @Author: 余霜
 * @date: 2020/1/29/15:36
 * @Version: 1.1
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<String> ys = new BinaryTree<>();

        System.out.println(ys.isEmpty());

        String[] a = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};


        for (int i = 0; i < 26; i++) {
            ys.insert(a[i]);
        }

        System.out.println(ys.deep());

        System.out.println(ys.count());

        TreeNode<String> root = ys.getRoot();

        TreeNode<String> find = ys.find("a");
        System.out.println(find.data);

        System.out.println("先序遍历");
        ys.preOrder();
        ys.preOrder(root);
        System.out.println();

        System.out.println("中序遍历");
        ys.inOrder();
        ys.inOrder(root);
        System.out.println();

        System.out.println("后序遍历");
        ys.afterOrder();
        ys.afterOrder(root);

        System.out.println();
        System.out.println("层次遍历");
        ys.levelOrder();

        System.out.println(ys.isEmpty());
        ys.clear();
        System.out.println(ys.isEmpty());


        System.out.println("BFS");
        List<TreeNode> list = ys.Bfs_tree(root);

        for (TreeNode o : list) {
            System.out.print(o.data+"\t");
        }
    }



}
