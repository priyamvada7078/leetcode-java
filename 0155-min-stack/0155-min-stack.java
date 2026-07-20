class MinStack {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        if (st.isEmpty()) {
            min = value;
        } else if (value < min) {
            min = value;

        }
        st.push(value);
    }

    public void pop() {
    int removed = st.pop();

    if (st.isEmpty()) {
        return;
    }

    if (removed == min) {
        min = st.peek();

        for (int num : st) {
            if (num < min) {
                min = num;
            }
        }
    }
}

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */