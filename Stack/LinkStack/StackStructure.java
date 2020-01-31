/**
 * @ClassName: StackStructure
 * @Description: TODO 栈数据结构
 * @Author: 余霜
 * @date: 2020/1/25/14:11
 * @Version: 1.0
 */
// 在JAVA中也有这自己的栈数据结构
// 功能也非常的全，继承于Vector集合
/*
    Stack<Integer> stack = new Stack<>();
 */

public class StackStructure <T> {

    static final int SIZE = 1024;

    public StackStructure() {
        this(SIZE);
    }

    public StackStructure(int size) {
        // 栈的最大容量
        int size1 = 0;
        // 顺序栈用数组实现
        Object[] stack = new Object[size];
    }

}
