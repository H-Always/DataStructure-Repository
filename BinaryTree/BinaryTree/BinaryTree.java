import java.util.*;

/**
 * @ClassName: BinaryTree
 * @Description: TODO 二叉树实现
 * @Author: 余霜
 * @date: 2020/1/29/14:31
 * @Version: 1.1
 */

/*
    2020/3/29/20:50
    增加了树的BFS
 */

// 这个是排序二叉树的插入
// 判定类型如果可以比较的话，可以用这个来实现(比如int)
// 虽然可以自动排序，但并不像红黑树一样是平衡的
/*
public void insert(int data){
        TreeNode<T> newNode = new TreeNode<T>(data);
        if(root == null){
            root = newNode;
        }else{
            TreeNode<T> current = root;
            TreeNode<T> parent;
            while(true){
                parent = current;
                if(current.data > data){
                    current = current.leftNode;
                    if(current == null){
                        parent.leftNode = newNode;
                        return ;
                    }
                }else{
                    current = current.rightNode;
                    if(current == null){
                        parent.rightNode = newNode;
                        return ;
                    }
                }
            }
        }
    }
 */

public class BinaryTree<T> implements IBinaryTree<T> {

    private TreeNode<T> root;
    int count = 0;

    @Override
    public boolean isFull() {
        return count() == (2 ^ deep() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public TreeNode<T> getLeftNode(TreeNode<T> node) {
        return node.leftNode;
    }

    @Override
    public TreeNode<T> getRightNode(TreeNode<T> node) {
        return node.rightNode;
    }

    @Override
    public TreeNode<T> getRoot() {
        return this.root;
    }

    @Override
    public int deep() {
        if (isEmpty())
            throw new NullPointerException("ThisTreeIsEmpty,NoDeep");

        int deep = 0;
        TreeNode<T> node = this.root;
        while (node != null) {
            node = node.leftNode;
            deep++;
        }
        return deep;
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public boolean insert(T key) {
        //如果根节点为空，证明这是第一次构建树结构,把值赋给根节点
        if (this.root == null) {
            this.root = new TreeNode<>(key);
            this.count++;
            return true;
        }

        //如果根节点不为空，就在最后一个节点的下一个节点插入
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            TreeNode<T> first = queue.poll();

            if (first.leftNode != null) {
                queue.add(first.leftNode);
            } else {
                //如果下一个节点的左节点为空，就插入进去
                first.leftNode = new TreeNode<>(key);
                this.count++;
                return true;
            }

            if (first.rightNode != null) {
                queue.add(first.rightNode);
            } else {
                //如果下一个节点的右节点为空，就插入进去
                first.rightNode = new TreeNode<>(key);
                this.count++;
                return true;
            }
        }
        return false;
    }


    @Override
    public TreeNode<T> find(T key) {
        if (isEmpty())
            throw new NullPointerException("ThisTreeIsEmpty");

        //查找用一下层次遍历
        //找到了就返回，没找到就返回空
        Queue<TreeNode<T>> nodeQueue = new LinkedList<>();
        TreeNode<T> node;
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            node = nodeQueue.peek();
            if (node.data.equals(key))
                return node;

            nodeQueue.poll();
            if (node.leftNode != null) {
                nodeQueue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                nodeQueue.add(node.rightNode);
            }
        }
        return null;
    }

    //递归的遍历其实没什么好说的，树的递归遍历其实是一种非常好理解的方法
    @Override
    public void preOrder(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.data + "\t");
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    @Override
    public void inOrder(TreeNode<T> root) {
        if (root != null) {
            inOrder(root.leftNode);
            System.out.print(root.data + "\t");
            inOrder(root.rightNode);
        }
    }

    @Override
    public void afterOrder(TreeNode<T> root) {
        if (root != null) {
            afterOrder(root.leftNode);
            afterOrder(root.rightNode);
            System.out.print(root.data + "\t");
        }
    }

    @Override
    public void preOrder() {
        if (isEmpty())
            throw new NullPointerException("ThisTreeIsEmpty");

        //非递归遍历都用栈来实现，原理也不难理解
        //一直向左走压栈，同时输出每次的栈头，这就是中间节点
        //如果遍历完了左边判断为空，就弹栈，返回上一层，遍历右边的左边
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = this.root;
        //只要当前节点不为空或者当前栈不为空，就证明这棵树还没有遍历完，继续while
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                System.out.print(stack.peek().data + "\t");
                current = current.leftNode;
            } else {
                current = stack.pop();
                current = current.rightNode;
            }
        }

        System.out.println();
    }

    @Override
    public void inOrder() {
        if (isEmpty())
            throw new NullPointerException("ThisTreeIsEmpty");

        //原理同先序遍历，就是把遍历位置换一下
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = this.root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.leftNode;
            } else {
                current = stack.pop();
                System.out.print(current.data + "\t");
                current = current.rightNode;
            }
        }
        System.out.println();
    }

    @Override
    public void afterOrder() {
        if (isEmpty())
            throw new NullPointerException("ThisTreeIsEmpty");

        //后序非递归，这个还是有点抽象的，所以注释写的详细
        Stack<TreeNode<T>> stack = new Stack<>();
        //当前遍历指针
        TreeNode<T> current = this.root;
        //记录最近访问节点的指针
        TreeNode<T> latest = null;

        //判断条件开始，如果树空了和栈空了同时满足代表遍历完了
        while (current != null || !stack.isEmpty()) {

            //一直向左走，直到走完
            while (current != null) {
                stack.push(current);
                current = current.leftNode;
            }

            //记录当前栈头
            current = stack.peek();
            //右子树为空或右子树已被访问时，该节点出栈,遍历该节点
            if (current.rightNode == null || current.rightNode == latest) {
                current = stack.pop();
                System.out.print(current.data + "\t");
                //将该节点赋值给最近一个访问节点
                latest = current;
                //此处很重要，将刚出栈节点设置为空，对应于while循环的条件之一，否则陷入死循环
                current = null;
            } else {
                //遍历右子树
                current = current.rightNode;
            }
        }

        System.out.println();
    }


    @Override
    public void levelOrder() {
        if (isEmpty())
            throw new NullPointerException("ThisTreeIsEmpty");

        //层次遍历用队列实现
        //原理就是把节点一个一个添加到队列里，然后队列依次出队
        Queue<TreeNode<T>> nodeQueue = new LinkedList<>();
        TreeNode<T> node;
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            node = nodeQueue.peek();
            System.out.print(node.data + "\t");
            nodeQueue.poll();
            if (node.leftNode != null) {
                nodeQueue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                nodeQueue.add(node.rightNode);
            }
        }
        System.out.println();
    }


    //BFS，本质和上面的一样，看着能简单点，返回一个链表,遍历一下链表就可以得到层次遍历
    @Override
    public List<TreeNode> Bfs_tree(TreeNode root) {
        Queue<TreeNode> myq = new LinkedList<>();
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return null;
        myq.add(root);
        while (!myq.isEmpty()) {
            int len = myq.size();
            for (int i = 0; i < len; i++) {
                if (myq.peek().leftNode != null) myq.add(myq.peek().leftNode);
                if (myq.peek().rightNode != null) myq.add(myq.peek().rightNode);
                res.add(myq.poll());
            }
        }
        return res;
    }

    @Override
    public boolean clear() {
        this.root = null;
        return true;
    }

}
