class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                open.push(i);
            }

            else if (c == '*') {
                star.push(i);
            }

            else { // c == ')'

                if (!open.isEmpty()) {
                    open.pop();
                }

                else if (!star.isEmpty()) {
                    star.pop();
                }

                else {
                    return false;
                }
            }
        }

        // Match remaining '(' with '*' that come after them
        while (!open.isEmpty() && !star.isEmpty()) {

            if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            }

            else {
                return false;
            }
        }

        return open.isEmpty();
    }
}