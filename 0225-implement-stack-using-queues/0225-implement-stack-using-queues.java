import java.util.*;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // O(1)
    public void push(int x) {
        q1.offer(x);
    }

    // O(n)
    public int pop() {

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int ans = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    // O(n)
    public int top() {

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int ans = q1.peek();

        q2.offer(q1.poll());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}