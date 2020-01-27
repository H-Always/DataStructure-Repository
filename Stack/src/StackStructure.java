/**
 * @ClassName: StackStructure
 * @Description: TODO 栈数据结构
 * @Author: 余霜
 * @date: 2020/1/25/14:11
 * @Version: 1.0
 */
public class StackStructure <T> {

    static final int SIZE = 1024;

    // 顺序栈用数组实现
    private Object[] stack;
    // 栈的最大容量
    private int Size;

    public StackStructure() {
        this(SIZE);
    }

    public StackStructure(int size) {
        this.Size = 0;
        this.stack = new Object[size];
    }

}
