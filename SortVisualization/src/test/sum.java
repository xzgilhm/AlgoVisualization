package test;
        import java.math.BigDecimal;

public class sum {

    public static void  main(String args[]){
        double sumx = 0;
        double sumy = 0;
        for(int i=1; i<=187;i++){
            sumx = 3 + sumx * 1.005;
            System.out.printf("第" + i +"年:" + String.valueOf(sumx) + "\n");
        }
//        for(int j=0;j<10;j++){
//            sumy += 3 * Math.pow(1.005,j);
//            System.out.printf(String.valueOf(sumy) + "\n");
//        }
//
    }


}
