class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String current = "1";
        for (int i = 2; i <= n; i++) {
            current = nextSequence(current);
        }
        return current;
    }
    private static String nextSequence(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == currentChar) {
                count++;
                i++;
            }
            result.append(count).append(currentChar);
            i++;
        }
        return result.toString();
    }
}
