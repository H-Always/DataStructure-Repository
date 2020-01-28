/**
 * @ClassName: QueueInterface
 * @Description: TODO 链队接口
 * @Author: 余霜
 * @date: 2020/1/28/16:12
 * @Version: 1.0
 */

public interface ILinkQueue<T> {

    //清空队列
    void clear();

    //判断队列是否为空
    boolean isEmpty();

    //获得队列当前长度
    int getSize();

    //获取队列元素
    Object peek();

    //插入队列
    boolean push(Object x);

    //弹出队列
    Object poll();

}
