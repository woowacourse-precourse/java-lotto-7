package lotto;

public class Stats {
    public static void printStats(int money, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Result.threeCnt + "개");
        System.out.println("4개 일치 (50,000원) - " + Result.fourCnt + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Result.fiveCnt + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Result.bonusCnt + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Result.sixCnt + "개");
        double profitPercent = 100 * profit / money;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitPercent);
    }
}
