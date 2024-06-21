class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isValidRow(board, row)) {
                return false;
            }
        }
        
        for (int col = 0; col < 9; col++) {
            if (!isValidColumn(board, col)) {
                return false;
            }
        }
        
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                if (!isValidBox(board, startRow, startCol)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            char current = board[row][col];
            if (current != '.') {
                if (set.contains(current)) {
                    return false;
                }
                set.add(current);
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            char current = board[row][col];
            if (current != '.') {
                if (set.contains(current)) {
                    return false;
                }
                set.add(current);
            }
        }
        return true;
    }
    
    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        Set<Character> set = new HashSet<>();
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                char current = board[row][col];
                if (current != '.') {
                    if (set.contains(current)) {
                        return false;
                    }
                    set.add(current);
                }
            }
        }
        return true;
    }
}
