import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Stack
 * @Description: TODO 顺序栈基本功能实现
 * @Author: 余霜
 * @date: 2020/1/25/15:09
 * @Version: 1.0
 */
public class Stack {

    static final int SIZE = 10;

    private Object[] stack;//元素容器
    private int Size;//元素个数

    // 默认长度为10
    public Stack() {
        this(SIZE);
    }

    //创建栈
    public Stack(int capacity) {
        this.Size = 0;
        this.stack = new Object[capacity];
    }

    //获取当前栈长度
    public int getCapacity() {
        return this.Size;
    }

    //判断是否为空
    public boolean isEmpty() {
        return this.Size == 0;
    }

    //判断栈为空
    public boolean isFull() {
        return Size == stack.length;
    }

    //入栈
    public void push(Object data) {
        if (isFull())
            return;

        this.stack[Size] = data;
        this.Size++;
    }

    //弹栈
    public Object pop() {
        if (isEmpty())
            throw new NullPointerException();

        Object data = (stack[--Size]);
        stack[Size] = null;

        return data;
    }

    //弹出所有栈中元素
    //返回一个列表
    public List<Object> popAll() {
        List<Object> stack = new ArrayList<>();
        for (int i = this.Size - 1; i >= 0; i--) {
            stack.add(this.stack[i]);
            this.stack[i] = null;
        }
        this.Size = 0;
        return stack;
    }
}
