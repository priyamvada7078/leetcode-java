class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                st.push(s.charAt(i));
            } else {
                if (!st.isEmpty() &&
                        ((a == ')' && st.peek() == '(') ||
                                (a == '}' && st.peek() == '{') ||
                                (a == ']' && st.peek() == '['))) {
                    st.pop();
                } else
                    return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}