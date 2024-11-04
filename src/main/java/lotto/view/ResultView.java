package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResultStatistic;
import lotto.domain.MyLotto;
import lotto.domain.Prize;

public class ResultView {

    public static final String LINE_BREAK = "\n";
    public static final int LOTTO_PRICE = 1000;

    public void printPurchaseLottoInfo(MyLotto lottos) {
        numberOfLotto(lottos.getNumberOfLotto());
        printPurchasedLottos(lottos);
    }

    private void numberOfLotto(int numberOfLotto) {
        System.out.println(LINE_BREAK +numberOfLotto+"개를 구매했습니다.");
    }

    private void printPurchasedLottos(MyLotto lottos) {
        for (Lotto lotto : lottos.getMyLottos()) {
            System.out.println(
                    lotto.getLotto()
                            .stream()
                            .map(i -> String.valueOf(i.toString()))
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }
    }

    public void printResult(LottoResultStatistic lottoResultStatistic,int numberOfLotto) {
        printStatistic(lottoResultStatistic);
        printProfit(lottoResultStatistic.calculateProfit(numberOfLotto* LOTTO_PRICE));
    }

    private static void printStatistic(LottoResultStatistic lottoResultStatistic) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResultStatistic.getPrizeFromStatistic(Prize.FIFTH) +"개");
        System.out.println("4개 일치 (50,000원) - " + lottoResultStatistic.getPrizeFromStatistic(Prize.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResultStatistic.getPrizeFromStatistic(Prize.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResultStatistic.getPrizeFromStatistic(Prize.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResultStatistic.getPrizeFromStatistic(Prize.FIRST)+"개");
    }

    public void printProfit(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
