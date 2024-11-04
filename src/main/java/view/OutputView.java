package view;

import lotto.Lotto;
import util.Rank;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(int[] resultCnt, double profitRate) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.FIFTH.getMatchCount() + "개 일치 (" + numberFormat.format(Rank.FIFTH.getPrize()) + "원) - " + resultCnt[4] + "개");
        System.out.println(Rank.FOURTH.getMatchCount() + "개 일치 (" + numberFormat.format(Rank.FOURTH.getPrize()) + "원) - " + resultCnt[3] + "개");
        System.out.println(Rank.THIRD.getMatchCount() + "개 일치 (" + numberFormat.format(Rank.THIRD.getPrize()) + "원) - " + resultCnt[2] + "개");
        System.out.println(Rank.SECOND.getMatchCount() + "개 일치, 보너스 볼 일치 (" + numberFormat.format(Rank.SECOND.getPrize()) + "원) - " + resultCnt[1] + "개");
        System.out.println(Rank.FIRST.getMatchCount() + "개 일치 (" + numberFormat.format(Rank.FIRST.getPrize()) + "원) - " + resultCnt[0] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
