package view;

import java.util.List;

import lotto.Lotto;

public class OutputView {
    public static void printLotto(int lottoCount, List<Lotto> lottoList) {
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(int[] rankings, float profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankings[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankings[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankings[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankings[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankings[0] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
