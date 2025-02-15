package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Prize;

import java.util.List;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(LottoResult lottoResult, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printPrizeResult(lottoResult, Prize.FIFTH, "3개 일치 (5,000원) - %d개%n");
        printPrizeResult(lottoResult, Prize.FOURTH, "4개 일치 (50,000원) - %d개%n");
        printPrizeResult(lottoResult, Prize.THIRD, "5개 일치 (1,500,000원) - %d개%n");
        printPrizeResult(lottoResult, Prize.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n");
        printPrizeResult(lottoResult, Prize.FIRST, "6개 일치 (2,000,000,000원) - %d개%n");

        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private static void printPrizeResult(LottoResult lottoResult, Prize prize, String format) {
        int matchCount = lottoResult.getPrizeResults().getOrDefault(prize, 0);
        System.out.printf(format, matchCount);
    }
}

