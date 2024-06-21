class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        backtrack(result, "", digits, 0, mapping);
        return result;
    }
    private void backtrack(List<String> result, String current, String digits, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            backtrack(result, current + letter, digits, index + 1, mapping);
        }
    }
}
