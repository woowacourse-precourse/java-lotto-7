package lotto;

public class OutputHandler {


    private int arr[];

    private int num;


    OutputHandler(int arr[],int num){
        this.arr = arr;
        this.num = num;
    }

    public void Print(){

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+arr[3]+"개");
        System.out.println("4개 일치 (50,000원) - "+arr[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+arr[5]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+arr[7]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+arr[6]+"개");

        long totalPrize = (5000 * arr[3]) + (50000 * arr[4]) + (1500000 * arr[5]) + (30000000 * arr[7]) + (2000000000 * arr[6]);
        double a = (double) totalPrize * 100 / num;
        a = Math.round(a * 100) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", a);
    }

}
