class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int m = needle.length();
        int n = haystack.length();
        int[] lps = computeLPSArray(needle);
        int i = 0;  
        int j = 0;  
        while (i < n) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j;
            } else if (i < n && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; 
    }
    private int[] computeLPSArray(String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        int length = 0;  
        int i = 1;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
