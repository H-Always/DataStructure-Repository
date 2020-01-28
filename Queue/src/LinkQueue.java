/**
 * @ClassName: ListQueue
 * @Description: TODO 链队实现
 * @Author: 余霜
 * @date: 2020/1/28/16:14
 * @Version: 1.0
 */
public class LinkQueue<T> implements ILinkQueue<T> {

    private QueueNode<T> front;//队首指针
    private QueueNode<T> rear;//队尾指针

    public LinkQueue() {
        this.front = this.rear = null;
    }

    //清空队列
    @Override
    public void clear() {
        this.front = this.rear = null;
    }

    //判断是否为空
    @Override
    public boolean isEmpty() {
        return this.front == null;
    }

    @Override
    public int getSize() {
        if (isEmpty())
            return 0;

        int Size = 0;
        QueueNode<T> temp = this.front;
        while (temp != null) {
            Size++;
            temp = temp.next;
        }
        return Size;
    }

    //获得当前队首元素
    @Override
    public Object peek() {
        if (isEmpty())
            throw new NullPointerException("ThisQueueIsEmpty");

        return this.front.data;
    }

    //入队
    @Override
    public boolean push(Object data) {
        QueueNode<T> temp = new QueueNode<T>(data);
        if (this.rear == null)
            this.front = this.rear = temp;
        else {
            this.rear.next = temp;
            this.rear = this.rear.next;
        }

        return true;
    }

    //出队
    @Override
    public Object poll() {
        if (isEmpty())
            throw new NullPointerException("ThisQueueIsEmpty");
        Object data = this.front.data;
        this.front = this.front.next;

        return data;
    }

}
