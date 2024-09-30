package class015;

import java.util.Stack;

public class Test015 {

}

class MinStack {
    int[] stack;
    int[] minStack;
    int limit = 8001;
    int size;

    public MinStack() {
        stack = new int[limit];
        minStack = new int[limit];
        size = 0;
    }

    public void push(int val) {
        stack[size] = val;
        if (size == 0 || val < minStack[size - 1]) {
            minStack[size] = val;
        } else {
            minStack[size] = minStack[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return stack[size - 1];
    }

    public int getMin() {
        return minStack[size - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
