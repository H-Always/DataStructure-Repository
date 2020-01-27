/**
 * @ClassName: SequenceListStructure
 * @Description: TODO 顺序表数据结构
 * @Author: 余霜
 * @date: 2020/1/25/15:12
 * @Version: 1.0
 */
public class SequenceListStructure<T> {
    static final int SIZE = 10;

    //顺序表长度
    private int Size;
    //这里结构使用数组
    private Object[] elements;


    //默认顺序表长度为10
    public SequenceListStructure() {
        this(SIZE);
    }

    //设置长度
    public SequenceListStructure(int size) {
        elements = new Object[size];
        this.Size = 0;
    }
}
