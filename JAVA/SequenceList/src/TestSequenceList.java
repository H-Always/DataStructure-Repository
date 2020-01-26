/**
 * @ClassName: TestSequenceList
 * @Description: TODO 顺序表功能测试
 * @Author: 余霜
 * @date: 2020/1/21/23:06
 * @Version: 1.0
 */
public class TestSequenceList extends SequenceList {

    public static void main(String[] args) {

        SequenceList<Integer> ys = new SequenceList(20);


        ys.print();

        for (int i = 0; i < 5; i++) {
            ys.insert(i);
        }

        ys.print();
        ys.insert(2,100);
        ys.print();
        ys.insert(4);
        ys.insert(3);
        ys.insert(4);
        ys.insert(6);
        ys.print();
        ys.deleteElement(4,-1);
        ys.deleteLocation(4);
        ys.print();
        System.out.println(ys.searchKey(6));
        System.out.println(ys.searchLocation(4));
        for (int i = 15; i < 40; i++) {
            ys.insert(i);
        }
        ys.print();

        System.out.println(ys.getLength());



    }

}
