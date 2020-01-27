import java.net.Inet4Address;
import java.util.Arrays;

/**
 * @ClassName: SequenceList
 * @Description: TODO 顺序表的基本方法实现
 * @Author: 余霜
 * @date: 2020/1/21/21:42
 * @Version: 1.0
 */
// 这个是注释部分的源码，用来自动扩容数组
// 其实本质上是创建了一个新的大容量数组来代替原来的数组
// 这个方法在以后实现以数组为基本数据结构的高级数据结构都可以使用
// 但这个方法一般不太好控制，没准就会内存溢出
/*
public static int[] copyOf(int[] original, int newLength){
        int[]copy=new int[newLength];
        System.arraycopy(original,0,copy,0,Math.min(original.length,newLength));
        return copy;
        }
*/

//System.arraycopy功能是复制数组
//如果看不懂可以看下面的for效果一样，删除某一元素
/*
if (this.Size - loction >= 0)
            System.arraycopy(this.elements, loction, this.elements, loction - 1, this.Size - loction);

        for (int i = loction; i < this.Size ; i++) {
            this.elements[i - 1] = this.elements[i];
        }
        */

public class SequenceList <T> {

    static final int SIZE = 1024;

    //顺序表长度
    private int Size;
    //这里结构使用数组
    private Object[] elements;


    //默认顺序表长度为10
    public SequenceList() {
        this(SIZE);
    }

    //设置长度
    public SequenceList(int size) {
        elements = new Object[size];
        this.Size = 0;
    }

    //判断顺序表是否为满
    public boolean isFull() {
        return this.Size == elements.length;
    }

    //判断顺序表是否为空
    public boolean isEmpty() {
        return this.Size == 0;
    }

    //获得当前长度
    public int getLength() {
        return this.Size;
    }

    //往顺序表后插入元素
    public boolean insert(int element) {
        if (isFull())
            return false;

        /*
        if (isFull()) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length + 10);
        }
        */

        this.elements[this.Size] = element;
        this.Size++;
        return true;
    }

    //在顺序表任意位置插入元素
    public boolean insert(int location, int element) {
        if (isFull())
            return false;

        /*
        if (isFull()) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length + 10);
        }
        */

        if (location > this.Size - 1 || location < 1)
            return false;

        if (this.Size + 1 - location >= 0)
            System.arraycopy(this.elements, location - 1, this.elements, location, this.Size + 1 - location);

        this.elements[location - 1] = element;
        this.Size++;
        return true;
    }

    //查找目标元素位置
    public int searchKey(Object key) {
        if (isEmpty()) {
            return -1;
        }

        for (int i = 0; i < this.Size; i++) {
            if (this.elements[i] == key) {
                return i + 1;
            }
        }

        return -1;
    }

    //查找顺序表对应位置元素
    public Object searchLocation(int location) {
        if (location < 0 || location >= this.Size)
            return Integer.MIN_VALUE;

        return this.elements[location - 1];
    }

    //删除符合的元素,number为-1时删除所有符合的元素,为其他时删除固定次数
    public void deleteElement(int Key, int number) {
        if (number == -1)
            number = Integer.MAX_VALUE;

        int location = searchKey(Key);

        while (location != -1 && number > 0) {
            if (this.Size - location >= 0)
                System.arraycopy(this.elements, location, this.elements, location - 1, this.Size - location);
            this.Size--;
            number--;
            location = searchKey(Key);
        }

    }

    //删除指定位置元素
    public void deleteLocation(int loction) {
        if (isEmpty())
            throw new NullPointerException();

        if (loction > this.Size || loction < 1)
            return;

        if (this.Size - loction >= 0)
            System.arraycopy(this.elements, loction, this.elements, loction - 1, this.Size - loction);

        this.Size--;
    }

    //打印顺序表所有元素
    public void print() {

        if (isEmpty())
            return;

        for (int i = 0; i < this.Size; i++) {
            System.out.print(this.elements[i] + "\t");
        }
        System.out.println();
    }

}
