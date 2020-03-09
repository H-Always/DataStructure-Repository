/**
 * @ClassName: LinkNode
 * @Description: TODO 链表节点数据结构
 * @Author: 余霜
 * @date: 2020/1/23/0:21
 * @Version: 1.0
 */

public class LinkNode <T> {

    //定义链表的头结点
    public Node head;

    //节点类
    class Node{
        int data;//数据域
        Node next;//地址域

        public Node(){//将头结点初始化为  data=-1   next=null
            this(-1);
        }

        //创建其他节点
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}



