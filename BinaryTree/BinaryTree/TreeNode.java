/**
 * @ClassName: TreeNode
 * @Description: TODO 二叉树节点结构
 * @Author: 余霜
 * @date: 2020/1/29/14:30
 * @Version: 1.0
 */
public class TreeNode<T> {

    //数据域
    Object data;
    //指针域
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;

    public TreeNode() {
        this.data = null;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TreeNode(Object data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

}
