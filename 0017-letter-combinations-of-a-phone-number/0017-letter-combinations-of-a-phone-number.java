class Solution {

    List<String> ans = new ArrayList<>();

    String[] map = {
        "",     //0
        "",     //1
        "abc",  //2
        "def",  //3
        "ghi",  //4
        "jkl",  //5
        "mno",  //6
        "pqrs", //7
        "tuv",  //8
        "wxyz"  //9
    };

    private void solve(int index, String digits, String current) {

        if(index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++) {
            solve(index + 1,
                  digits,
                  current + letters.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return ans;

        solve(0, digits, "");

        return ans;
    }
}