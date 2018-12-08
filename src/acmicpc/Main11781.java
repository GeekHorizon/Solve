package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 엔지니어의 행복도는 퇴근 후 집에 도착하는 시각이 늦을수록 낮아진다는 것이 증명되었다.
 * 
 * 조이의 대표 레드는 엔지니어의 행복도를 최대한 높여야 할 의무가 있기 때문에, 신중하게 퇴근 시간을 조정하기로 하였다.
 * 
 * 하지만 퇴근 시간을 조정하려면 먼저 엔지니어들이 집에 도착하는 시간을 알아야만 했다.
 * 
 * 이 문제를 미카에게 맡기려고 했지만, 6시가 넘어 미카는 이미 퇴근해버렸기 때문에 레드는 고민에 빠지고 말았다.
 * 
 * 레드를 도와 레드와 조이 엔지니어 모두의 행복도를 높여보도록 하자! 회사가 있는 서울은 N개의 지점으로 되어있다.
 * 
 * 각 지점은 1번부터 N번의 번호를 가지고 있고, 회사는 1번 지점에 있다.
 * 
 * M개의 도로들은 서로 다른 지점을 연결하고 있으며, 임의의 지점에서 모든 지점으로 이동할 수 있다.
 * 
 * 각각의 도로는 길이를 가지고 있으며, 거리 1을 이동하는 데 1분이 걸린다.
 * 
 * 편의상 퇴근은 0분에 한다고 가정한다.
 * 
 * 서울은 퇴근 시간에 도로가 막힌다.
 * 
 * 퇴근 시간이 아닐 때에는 거리 1을 이동하는 데 1분이 걸리지만,
 * 
 * 퇴근 시간이 겹칠 경우 혼잡한 도로는 거리 1을 이동하는 데 2분이 걸리게 된다. (물론 퇴근 시간에 막히지 않는 도로도 있다.)
 * 
 * 만약 퇴근 시간이 10분부터 20분이고 어떤 도로에 진입한 순간이 15분이며, 도로의 길이는 10이라면 이 도로를 전부 통과하는 데 걸리는
 * 시간은 •퇴근 시간 : 5분(15 ~ 20분)동안 간 거리 = 2.5를 가는 데 걸린 시간 : 5분 •퇴근 시간 외의 시간 : 나머지 거리
 * 7.5를 가는 데 걸린 시간 : 7.5분
 * 
 * 총 12.5분이 된다.
 * 
 * 첫째 줄에는 N, M과 퇴근 시간의 시작과 끝을 의미하는 S와 E가 정수로 주어진다.
 * 2 ≤ N ≤ 5,000
 * 1 ≤ M ≤ 100,000, 0 ≤ S < E ≤ 1,000,000,000
 * 
 * 다음 M개의 줄에는 서로 다른 정수 A, B와 도로의 길이를 의미하는 L, 그리고 t1, t2가 주어진다. 
 * 1 ≤ A, B ≤ N
 * 1 ≤ L ≤ 1,000,000,000
 * t1, t2 = 0 또는 1
 * 
 * https://www.acmicpc.net/problem/11781
 */
public class Main11781 {
     
    /**
     * 지점 
     * 2 ≤ N ≤ 5,000
     */
    private int vertexCount = 2;
     
    /**
     * 도로 
     * 1 ≤ M ≤ 100,000
     */
    private int edgeCount = 1;
     
    /**
     * 퇴근 시작 시간
     * 0 ≤ S < E ≤ 1,000,000,000
     */
    private double fromCongestionTime = 0;
     
    /**
     * 퇴근  종류 시간 
     * 0 ≤ S < E ≤ 1,000,000,000
     */
    private double toCongestionTime = 0; 
     
         
    /**
     * 정점 배열 
     */
    private double[][] vertexArray = new double[5001][5001]; 
     
    /**
     * 정점 배열 
     */
    private boolean[][] vertexCongestion = new boolean[5001][5001]; 
 
    /**
     * 
     */
     private Distance[] distanceEnum = new Distance[5001];
     
    /**
     * 메인
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
         
        Main11781 closingHour = new Main11781();
          
        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        String readTemp[] = br.readLine().split(" ");
         
     
        closingHour.initInfo(Integer.valueOf(readTemp[0]), 
                Integer.valueOf(readTemp[1]),
                Integer.valueOf(readTemp[2]),
                Integer.valueOf(readTemp[3]));
         
        for (int i = 0; i < closingHour.edgeCount; i++) {
            String edgeInputTemp[] = br.readLine().split(" ");
             
            closingHour.initVertexArray(Integer.valueOf(edgeInputTemp[0]),
                    Integer.valueOf(edgeInputTemp[1]),
                    Integer.valueOf(edgeInputTemp[2]),
                    Integer.valueOf(edgeInputTemp[3]),
                    Integer.valueOf(edgeInputTemp[4]));
        }
         
        double maxDistance = closingHour.runArray();
        long maxLongDistance = (long)maxDistance;
         
        if (maxDistance == (long)maxDistance) {
            System.out.printf("%.0f", maxDistance);
        } else {
            System.out.printf("%.1f", maxDistance);
        }
         
     
        /*
        closingHour.initInfo(10, 
                900000,
                500,
                10000);
        Random rand = new Random();
         
        for (int i = 1; i <= 5000; i++) {
             
            for (int j = i + 1; j <= 5000; j++) {
                 
                closingHour.initVertexArray(i, j,
                        rand.nextInt(8000),
                        rand.nextInt(1),
                        rand.nextInt(1));
            }
        }
         
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("시작    " + System.currentTimeMillis());
        System.out.println(Math.round(closingHour.runArray()));
        System.out.println("끝    " + System.currentTimeMillis());
        System.out.println((System.currentTimeMillis() - currentTimeMillis)/1000);
        */
    }
     
    /**
     * 지점 정보 생성
     */
    public void initInfo(int n, int m, int s, int e) {
        vertexCount = n;
        edgeCount = m;
        fromCongestionTime = s;
        toCongestionTime = e;
         
        for (int i = 1; i <= vertexCount; i++) {
            distanceEnum[i] = new Distance();
             
            for (int j = 1; j <= vertexCount; j++) {
                vertexArray[i][j] = -1;
            }
        }
    }
     
    /**
     * 지점 정보 생성
     */
    public void initVertexArray(int a, int b, int l, int t1, int t2) {
        vertexArray[a][b] = l;
        vertexArray[b][a] = l;
        vertexCongestion[a][b] = (t1 == 1);
        vertexCongestion[b][a] = (t2 == 1);
    }
     
    /**
     * 최단 거리 확인 
     */
    public double runArray() {
         
         
        distanceEnum[1].setDistance(0);
        distanceEnum[1].setDistanceStat(DistanceStat.UNSET);
         
        for (int i = 1; i <= vertexCount; i++) {
            double time = Double.MAX_VALUE;
            int minVertex = 0;
             
            for (int j = 1; j <= vertexCount; j++) {
                 
                if (distanceEnum[j].getDistanceStat() != DistanceStat.UNSET) {
                    continue;
                }if (time > distanceEnum[j].getDistance()) {
                    time = distanceEnum[j].getDistance();
                    minVertex = j;
                }
            }
             
            if (minVertex == 0) {
                continue;
            }
             
            distanceEnum[minVertex].setDistanceStat(DistanceStat.SET);
             
            for (int j = 1; j <= vertexCount; j++) {
                 
                 
                if (vertexArray[minVertex][j] > 0 && distanceEnum[j].getDistanceStat() != DistanceStat.SET) {
                     
                    double evaluationTime = time + vertexArray[minVertex][j];
 
                    if (vertexCongestion[minVertex][j] == true) {
                         
                        if (time < toCongestionTime) {
                             
                            if (evaluationTime > fromCongestionTime) {
                                 
                                if (time > fromCongestionTime) {
                                    evaluationTime += evaluationTime - time; 
                                } else {
                                    evaluationTime += evaluationTime - fromCongestionTime; 
                                }
                                 
                                if (evaluationTime > toCongestionTime) {
                                    evaluationTime -= (evaluationTime - toCongestionTime) / 2.0;
                                }
                            }
                        } 
                    }
                 
                    if (distanceEnum[j].getDistanceStat() == DistanceStat.UNKNOWN) {
                        distanceEnum[j].setDistance(evaluationTime);
                        distanceEnum[j].setDistanceStat(DistanceStat.UNSET);
                    } else if (evaluationTime < distanceEnum[j].getDistance()) {
                        distanceEnum[j].setDistance(evaluationTime);
                    }
                }
            }
        }       
         
        double maxTime = distanceEnum[1].getDistance(); 
         
        for (int j = 2; j <= vertexCount; j++) {
             
            if (maxTime <= distanceEnum[j].getDistance() && distanceEnum[j].getDistanceStat() == DistanceStat.SET) {
                maxTime = distanceEnum[j].getDistance();
            } 
        }
         
        return maxTime;
    }
     
     
    enum DistanceStat {
        SET, UNSET, UNKNOWN;
    }
 
    public class Distance {
         
        private double distance = 0f;
         
        private DistanceStat distanceStat = DistanceStat.UNKNOWN;
         
        public double getDistance() {
            return this.distance;           
        }
         
        public void setDistance(double distance) {
            this.distance = distance;
        }
 
        public DistanceStat getDistanceStat() {
            return distanceStat;
        }
 
        public void setDistanceStat(DistanceStat distanceStat) {
            this.distanceStat = distanceStat;
        }
    }
}