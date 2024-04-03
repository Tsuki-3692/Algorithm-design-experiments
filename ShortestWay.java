import java.util.ArrayList;
import java.util.List;

public class ShortestWay {

    public static void main(String[] args) {
        int[][] graph = {{0, 3, 8, 1000, -4},
                {1000, 0, 1000, 1, 7},
                {1000, 4, 0, 1000, 1000},
                {2, 1000, -5, 0, 1000},
                {1000, 1000, 1000, 60, 0}};
        int[][] dist = new int[5][5];
        int[][] next = new int[5][5]; // 用于记录最短路径上的下一个节点

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != 1000 && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("Shortest paths:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    List<Integer> path = new ArrayList<>();
                    path.add(i + 1);
                    int current = i;
                    while (current != j) {
                        current = next[current][j];
                        path.add(current + 1);
                    }
                    System.out.println("从" + (i + 1) + " 到" + (j + 1) + "的最短路径: " + path+" 长度是： "+dist[i][j]);
                }
            }
        }
    }
}

