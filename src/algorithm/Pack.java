package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Pack
 */
public class Pack {

    private int[] volume; 
    private int[] need;
    private int n;
    private int capacity;
    private int[][] cache;

    public static void main(String[] args) {
  
        System.out.println(new Pack().test(new int[]{4, 2, 6, 4, 2, 10}, new int[]{7, 10, 6, 7, 5, 4}, 6, 10));

    }

    public int test(int[] volume, int[] need, int n, int capacity) {
        this.n = n;
        this.volume = volume;
        this.need = need;
        this.capacity = capacity; 
        this.cache = new int[capacity + 1][n + 1];

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }

        //        return pack(capacity, 0);
        List<Integer> ret = new LinkedList<>();
        reconstruct(capacity, 0, ret);
        System.out.println(ret);

        return pack(capacity, 0);
    }

    public int pack(int capacity, int item) {
        if (item == n) {
            return 0;
        }

        int ret = cache[capacity][item];

        if (ret != -1) {
            return ret;
        }

        ret = pack(capacity, item + 1);

        if (capacity >= volume[item]) {
            ret = Math.max(ret, pack(capacity - volume[item], item + 1) + need[item]);
        }

        return ret;
    }

    public void reconstruct(int capacity, int item, List<Integer> picked) {
        if (item == n) {
            return ;
        }

        if (pack(capacity, item) == pack(capacity, item + 1)) {
            reconstruct(capacity, item + 1, picked);
        } else {
            picked.add(item);
            reconstruct(capacity - volume[item], item + 1, picked);
        }
    }
}