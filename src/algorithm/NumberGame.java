package algorithm;

public class NumberGame {



    public static void main(String[] args) {
        NumberGame ng = new NumberGame();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                ng.cache[i][j] = EMPTY;
            }
        }
        
        //ng.board = new int[] {7, -5, 8, 5, 1, -4, -8, 6, 7, 9};
        ng.board = new int[] {100, -1000, -1000, 100, -1000, -1000};

        System.out.println(ng.play(0, 5));

    }
    private static final int EMPTY = -987654321;
    int n, board[];
    int cache[][] = new int[50][50];
    
    public int play(int left, int right) {
        if (left > right) return 0;

        int ret = cache[left][right];
        if (ret != EMPTY) return ret;

        ret = Math.max(board[left] - play(left + 1, right), 
                        board[right] - play(left, right -1));

        if (right - left + 1 >= 2) {
            ret = Math.max(ret, -play(left+2, right));
            ret = Math.max(ret, -play(left, right - 2));
        }

        cache[left][right] = ret;

        return ret;
    }
}
