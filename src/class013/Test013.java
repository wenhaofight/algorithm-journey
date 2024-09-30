package class013;

public class Test013 {

}

class MyCircularQueue {
    int[] queue;
    int limit;
    int size;
    int left;
    int right;

    public MyCircularQueue(int k) {
        queue = new int[k];
        limit = k;
        size = 0;
        left = 0;
        right = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[right] = value;
            right = right == limit - 1 ? 0 : right + 1;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            left = left == limit - 1 ? 0 : left + 1;
            size--;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[left];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            int index = right == 0 ? limit - 1 : right - 1;
            return queue[index];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
