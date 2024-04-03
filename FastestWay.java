public class FastestWay {
    public static void main(String[] args) {
        int[][] a = {{7, 9, 3, 40, 8}, {8, 5, 6, 4, 5}};//a1,a2
        int[][] t = {{2, 3, 1, 3}, {2, 1, 2, 2}};//t1,t2
        int[] e = {2, 4};//e1,e2
        int[] x = {3, 6};//x1,x2
        int[] f1 = new int[5];
        int[] f2 = new int[5];
        f1[0] = e[0] + a[0][0];
        f2[0] = e[1] + a[1][0];
        for (int j = 1; j < 5; j++) {
            if (f1[j - 1] + a[0][j] <= f2[j - 1] + t[1][j - 1] + a[0][j]) {
                f1[j] = f1[j - 1] + a[0][j];
            } else {
                f1[j] = f2[j - 1] + t[1][j - 1] + a[0][j];
            }
            if (f2[j - 1] + a[1][j] <= f1[j - 1] + t[0][j - 1] + a[1][j]) {
                f2[j] = f2[j - 1] + a[1][j];
            } else {
                f2[j] = f1[j - 1] + t[0][j - 1] + a[1][j];
            }
        }
        if (f1[4] + x[0] <= f2[4] + x[1]) {
            System.out.println(f1[4] + x[0]);
        } else {
            System.out.println(f2[4] + x[1]);
        }
        int flag = 0;
        if (f1[0] < f2[0]) {
            System.out.println("e1");
            System.out.println("a1,1");
            flag = 1;
        }
        else {
            System.out.println("e2");
            System.out.println("a2,1");
            flag = 2;
        }
        for (int j = 1; j < 4; j++) {
            if(f1[j]<f2[j]&&flag==1){
                System.out.println("a1,"+(j+1));
                flag=1;
            }else if(f1[j]>f2[j]&&flag==1){
                System.out.println("t1,"+j);
                System.out.println("a2,"+(j+1));
                flag=2;
            } else if (f1[j] < f2[j] && flag == 2) {
                System.out.println("t2,"+j);
                System.out.println("a1,"+(j+1));
                flag=1;
            } else {
                System.out.println("a2,"+(j+1));
                flag=2;
            }
        }
        if (f1[4] + x[0] <= f2[4] + x[1]) {
            System.out.println("a1,5");
            System.out.println("x1");
        } else {
            System.out.println("a2,5");
            System.out.println("x2");
        }
    }
}
