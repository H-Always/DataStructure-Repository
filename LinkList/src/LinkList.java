/**
 * @ClassName: LinkList
 * @Description: TODO 链表基本功能实现
 * @Author: 余霜
 * @date: 2020/1/23/0:44
 * @Version: 1.0
 */
public class LinkList<T> extends LinkNode<T> {

    //初始化链表
    //初始化的时候创建一个头结点
    public LinkList() {
        this.head = new Node();
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    //头插法创建链表
    public void insertHead(int data) {
        //创建一个新节点
        Node node = new Node(data);

        node.next = head.next;
        head.next = node;

    }

    //尾插法创建链表
    public void insertTail(int data) {
        Node temp;
        Node node = new Node(data);
        temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = node;
    }

    //获得单链表的长度
    public int getLength() {
        int length = 0;//长度标志量
        Node temp;
        temp = head.next;
        while (temp != null) {//遍历整个链表得到链表长度
            length++;
            temp = temp.next;
        }
        return length;
    }

    //获得第k个位置的元素
    public int getNode(int position) {
        if (position > getLength() || position < 1)
            throw new NullPointerException();

        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    //插入数据到指定位置
    public boolean insertPosition(int position, int data) {
        if (position < 1 || position > getLength())
            return false;

        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(data);

        node.next = temp.next;
        temp.next = node;
        return true;
    }

    //删除目标元素的节点
    public boolean deleteData(int data) {
        if (isEmpty())
            return false;

        Node temp = head;
        while (temp.next != null) {

            if (temp.next.data == data)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }

        return true;
    }

    //删除目标元素的节点
    public boolean deleteNode(int position) {
        if (isEmpty() || position > getLength() || position < 1)
            return false;

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return true;
    }

    //逆置链表
    public boolean reverse() {
        Node newHead = new Node();
        Node p = head.next;
        Node q = p.next;

        while (p.next != null) {
            p.next = newHead.next;
            newHead.next = p;
            p = q;
            q = q.next;
        }
        p.next = newHead.next;
        newHead.next = p;
        head = newHead;
        return true;
    }

    //打印链表所有元素
    public void print() {
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }
}
