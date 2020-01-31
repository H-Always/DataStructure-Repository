/**
 * @ClassName: IBinaryTree
 * @Description: TODO 二叉树功能接口
 * @Author: 余霜
 * @date: 2020/1/29/14:34
 * @Version: 1.0
 */
public interface IBinaryTree<T> {

    //判断是否是满二叉树
    boolean isFull();

    //判断二叉树是否为空
    boolean isEmpty();

    //获得最树的大深度
    int deep();

    //获得根节点
    TreeNode<T> getRoot();

    //获得左节点
    TreeNode<T> getLeftNode(TreeNode<T> node);

    // 获取结点的右孩子结点
    TreeNode<T> getRightNode(TreeNode<T> node);

    //节点个数
    int count();

    //插入节点
    boolean insert(T key);

    //差找第一次出现目标值的节点
    TreeNode<T> find(T key);

    //递归先序遍历二叉树
    void preOrder(TreeNode<T> root);

    //递归中序遍历二叉树
    void inOrder(TreeNode<T> root);

    //递归后序遍历二叉树
    void afterOrder(TreeNode<T> root);

    //先序遍历二叉树
    void preOrder();

    //中序遍历二叉树
    void inOrder();

    //后序遍历二叉树
    void afterOrder();

    //层次遍历二叉树
    void levelOrder();

    //清空树
    boolean clear();

}
