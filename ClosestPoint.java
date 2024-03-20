import java.util.Arrays;

public class ClosestPoint {
    public static double getMinDistance(int[][] points, boolean flag) {
        double min = 1000;
        //flag是否使用分治法
        if (!flag) {//暴力
            for (int i = 0; i < points.length; i++) {//遍历所有点
                for (int j = i + 1; j < points.length; j++) {
                    float dis = (float) Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    if (dis < min) {
                        min = dis;
                    }
                }
            }
        } else {//使用分治法
            min = calculateClosestDistance(points);
        }
        return min;
    }

    public static double calculateClosestDistance(int[][] points) {
        // 根据横坐标对点进行排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        return calculateClosestDistance(points, 0, points.length - 1);
    }

    public static double calculateClosestDistance(int[][] points, int left, int right) {
        // 当点的数量小于等于3时，使用暴力法计算最近点距离
        if (right - left + 1 <= 3) {
            return baoli(points, left, right);
        }

        // 分割点集合为两部分
        int mid = (left + right) / 2;
        double midX = points[mid][0];

        double minDistanceLeft = calculateClosestDistance(points, left, mid);
        System.out.println("Left:"+minDistanceLeft);
        double minDistanceRight = calculateClosestDistance(points, mid + 1, right);
        System.out.println("Right:"+minDistanceRight);
        double minDistance = Math.min(minDistanceLeft, minDistanceRight);

        // 找到中间区域内的点
        int[][] midPoints = new int[right - left + 1][2];
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i][0] - midX) <= minDistance) {
                midPoints[count++] = points[i];
            }
        }
        // 根据纵坐标对中间区域内的点进行排序
        Arrays.sort(midPoints, 0, count, (a, b) -> Integer.compare(a[1], b[1]));
        // 在中间区域内计算最近点距离
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count && midPoints[j][1] - midPoints[i][1] < minDistance; j++) {
                double distance = euclideanDistance(midPoints[i], midPoints[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    public static double euclideanDistance(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static int[][] initPoints() {//初始化点
        int[][] points = new int[100][2];
        for (int i = 0; i < 100; i++) {
            points[i][0] = (int) (Math.random() * 1000);
            points[i][1] = (int) (Math.random() * 1000);
        }
        return points;
    }

    public static double baoli(int[][] points, int left, int right) {//暴力计算
        double minDistance = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double distance = euclideanDistance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
}
