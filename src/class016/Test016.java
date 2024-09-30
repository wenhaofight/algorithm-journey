package class016;

public class Test016 {
}

class MyCircularDeque {
    int[] deque;
    int size;
    int left;
    int right;
    int limit;

    public MyCircularDeque(int k) {
        deque = new int[k];
        size = 0;
        left = 0;
        right = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                left = right = 0;
                deque[left] = value;
            } else {
                left = left == 0 ? limit - 1 : left - 1;
                deque[left] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                left = right = 0;
                deque[0] = value;
            } else {
                right = right == limit - 1 ? 0 : right + 1;
                deque[right] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            left = left == limit - 1 ? 0 : left + 1;
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            right = right == 0 ? limit - 1 : right - 1;
            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[left];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[right];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}
