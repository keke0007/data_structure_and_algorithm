package 队列;

import java.util.Stack;

/**
 * @author jk
 * @version 1.0.0
 * @create 2020/7/28 15:33
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 通过次数63,789提交次数97,816
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _225_用队列实现栈 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public _225_用队列实现栈() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    //入队
    public void push(int x) {
        inStack.push(x);
    }

    //出队
    public int pop() {
//如果outStack为空则inStack弹出
        /*if (outStack.isEmpty()) {
            while (!inStack .isEmpty()) {
                outStack.push(inStack.pop());
            }
        }*/
        checkOutStack();
        return outStack.pop();
    }

    //获取队头元素
    public int peek() {
      /*  if (outStack.isEmpty()) {
            while (!inStack .isEmpty()) {
                outStack.push(inStack.pop());
            }
        }*/
        checkOutStack();
        return outStack.peek();
    }

    //是否为空
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
