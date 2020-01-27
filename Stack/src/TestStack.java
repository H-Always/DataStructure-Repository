/**
 * @ClassName: TestStack
 * @Description: TODO 栈方法测试
 * @Author: 余霜
 * @date: 2020/1/25/15:49
 * @Version: 1.0
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> ys = new Stack();

        ys.pop();

        for (int i = 0; i < 10; i++) {
            ys.push(i);
        }
        System.out.println(ys.isFull());
        System.out.println(ys.getCapacity());


        int a = ys.pop();
        System.out.println(a);
        System.out.println(ys.getCapacity());
        System.out.println(ys.popAll());

        System.out.println(ys.getCapacity());
        System.out.println(ys.isFull());
        System.out.println(ys.isEmpty());

    }
}
