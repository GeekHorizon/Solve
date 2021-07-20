package algorithm;

import java.util.Arrays;

public class Morse {
    
    public static void main(String[] args) {
        
        // 완전 탐색
        //new Morse().generate(2, 2, "");

        // k 번째 확인
        Morse g2 = new Morse();
        g2.skip = 4;
        g2.generate2(2, 2, "");
        System.out.println(g2.generate2Count);

        // k 번째 확인
        Morse g3 = new Morse();
        g3.skip = 4;
        g3.calcBino();
        g3.generate3(2, 2, "");
        System.out.println(g3.generate3Count);


        // k 번째 확인
        Morse g4 = new Morse();
        g4.calcBino();
        System.out.println(g4.kth(2, 2, 4));
    }


    public void generate(int n, int m, String s) {
        if (n == 0 && m == 0) {
            System.out.println(s);
            return ;
        }

        if (n > 0) {
            generate(n - 1, m, s + "-");
        } 
        if (m > 0) {
            generate(n, m - 1, s + "o");
        }
    }
    
    int skip;
    int generate2Count = 0;
    public void generate2(int n, int m, String s) {
        if (skip < 0) {
            return ;
        }
        if (n == 0 && m == 0) {
            
            if (skip == 0) {
                System.out.println(s);
            }
            
            skip--;
            return ;
        }
        generate2Count++;
        if (n > 0) {
            generate2(n - 1, m, s + "-");
        } 
        if (m > 0) {
            generate2(n, m - 1, s + "o");
        }
    }

    final long M = 1000000000 + 100;
    long[][] bino = new long[201][201];
    public void calcBino() {
        for (int i = 0; i <= 200; i++) {
            Arrays.fill(bino[i], 0);
            bino[i][0] = bino[i][i] = 1;
            for (int j = 1; j < i; j++) {
                bino[i][j] = Math.min(M, bino[i-1][j-1] + bino[i-1][j]);
            }
        }

    }
    
    int generate3Count = 0;

    public void generate3(int n, int m, String s) {
        if (skip < 0) return;

        if (n == 0 && m == 0) {
            if (skip == 0) {
                System.out.println(s);
            }
            --skip;
            return;
        }

        if (bino[n + m][n] <= skip) {
            skip -= bino[n + m][n];
            return ;
        }

        generate3Count++;

        if (n > 0) {
            generate3(n - 1, m, s + "-");
        } 
        if (m > 0) {
            generate3(n, m - 1, s + "o");
        }
    }

    public String kth(int n, int m, long skip) {
        if (n == 0) {
            return "o".repeat(m);
        }

        if (skip < bino[n+m -1][n-1]) {
            return "-" + kth(n-1, m, skip);
        }
        return "o" + kth(n, m-1, skip - bino[n+m-1][n-1]);
    }
}
