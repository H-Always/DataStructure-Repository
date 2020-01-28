/**
 * @ClassName: QueueTest
 * @Description: TODO 测试链队
 * @Author: 余霜
 * @date: 2020/1/28/16:19
 * @Version: 1.0
 */
public class QueueTest {
    public static void main(String[] args) {
        LinkQueue<Integer> ys = new LinkQueue<Integer>();

        System.out.println(ys.getSize());
        System.out.println(ys.isEmpty());

        ys.push(100);
        System.out.println(ys.getSize());
        System.out.println(ys.isEmpty());
        for (int i = 0; i < 10; i++) {
            ys.push(i);
        }

        System.out.println(ys.getSize());
        System.out.println(ys.peek());
        System.out.println(ys.poll());
        System.out.println(ys.peek());
        System.out.println(ys.getSize());

    }
}
