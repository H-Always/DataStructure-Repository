/**
 * @ClassName: TestLinkList
 * @Description: TODO 链表基本功能测试
 * @Author: 余霜
 * @date: 2020/1/23/1:16
 * @Version: 1.0
 */
public class TestLinkList extends LinkNode {
    public static void main(String[] args) {
        LinkList<Integer> ys = new LinkList();
        ys.insertHead(1);
        for (int i = 0; i < 5; i++) {
            ys.insertHead(i);
        }
        ys.print();

        for (int i = 5; i < 10; i++) {
            ys.insertTail(i);
        }
        ys.print();
        ys.reverse();
        ys.insertPosition(5,100);
        ys.print();


        System.out.println(ys.getNode(11));
        System.out.println(ys.deleteData(9));
        ys.print();
        ys.print();

    }
}
