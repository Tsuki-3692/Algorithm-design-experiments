public class Main {
    public static void main(String[] args) {
//        // 测试 Strassen 算法
//        int [][]A=new int[16][16];
//        int [][]B=new int[16][16];
//        for(int i=0;i<16;i++){
//            for(int j=0;j<16;j++){
//                A[i][j]=1;
//                B[i][j]=1;
//            }
//        }
//        int [][]C = Strassen.strassen(A,B);
//        for (int[] ints : C) {
//            for (int j = 0; j < C[0].length; j++) {
//                System.out.print(ints[j] + " ");
//            }
//            System.out.println();
//        }

        // 测试 ClosestPoint 算法
        int[][] points = ClosestPoint.initPoints();
        System.out.println("暴力法:"+ClosestPoint.getMinDistance(points, false));
        System.out.println("分治法:" + ClosestPoint.getMinDistance(points, true));

        //测试Draw
//        Draw example = new Draw();
//        example.setVisible(true);
    }
}
