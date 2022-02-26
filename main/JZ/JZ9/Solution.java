package code.JZ9;

/**
 * TODO ..
 * User: 钟镇鸿
 * Date: 2022/2/26
 * Time: 20:49
 * Description:
 */
import java.util.Stack;

/**1. 当插入时，直接插入 stack1
 * 2. 当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，
 *             当 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素*/
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.size() <= 0){
            while(stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}