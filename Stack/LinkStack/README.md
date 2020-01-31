## 顺序栈
### 栈就不多介绍了，FIFO，在JAVA中有自己的栈数据结构
`Stack<Integer> stack = new Stack<>();`
### 作者在实现二叉树遍历的时候注意到了这里有两个功能完全一样的方法
### empty()和isEmpty()，比较有意思
### 我们来看一下源码
    `public boolean empty() {
         return this.size() == 0;
     }`
     
    `public synchronized boolean isEmpty() {
              return this.elementCount == 0;
     }`
     
#### empty()函数会调用vector中size()函数，再判断是否为空
#### isEmpty会直接调用vector中的方法判断
#### 反正就结论来说，没区别，使用那个都一样