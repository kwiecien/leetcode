import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return areRowsAndColumnsValid(board) && areSubBoxesValid(board);
    }

    private boolean areRowsAndColumnsValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> row = new HashMap<>();
            Map<Character, Integer> column = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                row.merge(board[i][j], 1, Integer::sum);
                column.merge(board[j][i], 1, Integer::sum);
            }
            row.put('.', 1);
            column.put('.', 1);
            if (Collections.max(row.values()) != 1 || Collections.max(column.values()) != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean areSubBoxesValid(char[][] board) {
        for (int x = 0; x <= 6; x += 3) {
            for (int y = 0; y <= 6; y += 3) {
                Map<Character, Integer> box = new HashMap<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        box.merge(board[x + i][y + j], 1, Integer::sum);
                    }
                }
                box.put('.', 1);
                if (Collections.max(box.values()) != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}