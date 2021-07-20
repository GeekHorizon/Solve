package algorithm;

import java.util.Arrays;
import java.util.List;

public class Factorials {
        
    public static void main(String[] args) {
        
        Factorials f = new Factorials();

        f.factorials[1] = 1;
        for (int i = 2; i < f.factorials.length; i++) {
            f.factorials[i] = f.factorials[i -1] * i;
        }
        List<Integer> x = Arrays.asList(3, 4, 1, 2, 5, 6, 7, 8 ,9, 10);

        System.out.println(f.getIndex(x));
        
    }

    int[] factorials = new int[12];

    public int getIndex(List<Integer> x) {
        int ret = 0;

        for (int i = 0; i < x.size(); i++) {
            int less = 0;
            for (int j = i + 1; j < x.size(); j++) {
                if (x.get(j) < x.get(i)) {
                    less++;
                }
                ret += factorials[x.size() - i - 1] * less;
            }
        }
        return ret;
    }
}
