package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class ShortestPath {

    public static void main(String[] args) {
        
		Queue<Integer> a = new LinkedList<>();

		a.offer(111);

		IntStream.range(0, 10)
		.forEach(a::offer);
    }
    
    //도시의 수
	private static int n;
	//두 도시 간의 거리를 저장하는 배열
	private static int dist[][];

    private static int shortestPath(List<Integer> path, boolean visited[], int currentLength) {
		int len = path.size();
		// 기저 사례: 모든 도시를 다 방문했을 때는 시작 도시로 돌아가고 종료한다.
		if (len == n) {
			return currentLength + dist[path.get(0)][path.get(len - 1)];
		}
		//임의의 매운 큰 값으로 초기화
	    int ret = 987654321;

		//다음 방문할 도시를 전부 시도한다.
		for(int next = 0; next < n; ++next) {
			//이미 방문했다면 조건 검사하지 않음.
			if (visited[next]) continue;
			// path가 결정된 크기를 할당.
			int here = path.size() - 1;
			//경로에 인덱스를 할당.
			path.add(next);
			//방문 했음을 표시.
			visited[next] = true;
			//나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
			int cand = shortestPath(path, visited, currentLength + dist[here][here]);
			//경로의 값이 더 짧은 값을 선택한다.
			ret = Math.min(ret, cand);
			//다음 재귀호출시 방문할 경우의 수 계산을 위해 false 할당.
			visited[next] = false;
			//마지막 원소의 값 삭제.
			path.remove(here);
		}
		return ret;
	}

    static int MAX = 20;
    static int[][] cache = new int[MAX][1<<MAX];//-1로 초기화
    private static int shortestPath2(int here, int visited) {
        
        if (visited == (1<<n)-1) return dist[here][0];

        int ret = cache[here][visited];

        if (ret >= 0) {
            return ret;
        }

        ret = 987654321;

        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) != 0) continue;

            int cand = dist[here][next] + shortestPath2(next, visited + (1<<next));
            ret = Math.min(ret, cand);
            cache[here][visited]= ret;
        }

        return ret;
    }


	public void test() {

		PriorityQueue<Integer> task = new PriorityQueue<>((i , k) -> 0);
		IntStream.range(0, 10).forEach(a -> System.out.println(a));

	}


}
