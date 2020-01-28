/**
 * @ClassName: QueueNode
 * @Description: TODO 链队节点结构
 * @Author: 余霜
 * @date: 2020/1/28/15:55
 * @Version: 1.0
 */

// JAVA中有自己的队列集合
/*
 Queue<String> queue = new LinkedList<String>();
 */
public class QueueNode<T> {

    //数据域
    public Object data;
    //指针域
    public QueueNode<T> next;

    public QueueNode() {
        this.data = null;
        this.next = null;
    }

    public QueueNode(Object data) {
        this.data = data;
        this.next = null;
    }

    public QueueNode(Object data, QueueNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
