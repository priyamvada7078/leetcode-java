import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            // Assume the current asteroid survives
            boolean alive = true;

            // Collision is possible only when:
            // top of stack is moving right and current asteroid is moving left
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {

                if (stack.peek() < -asteroid) {
                    // Top asteroid is smaller, so it explodes
                    stack.pop();

                } else if (stack.peek() == -asteroid) {
                    // Both are of equal size, so both explode
                    stack.pop();
                    alive = false;
                    break;

                } else {
                    // Current asteroid is smaller, so it explodes
                    alive = false;
                    break;
                }
            }

            // If current asteroid survived all collisions, push it
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] ans = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}