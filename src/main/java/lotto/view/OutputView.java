package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.PaymentInput;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private static final String LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String RESULT = "%d개 일치 (%d원) - %d개\n";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String INVESTMENT = "총 수익률은 %.1f%%입니다.";

    public static void printLottosInfo(List<Integer> lottos) {
        System.out.println(lottos);
    }

    public static void showResult(LottoResult lottoResult, PaymentInput paymentInput) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
        for (Rank rank : lottoResult.getPrizeResult().keySet()) {
            int cnt = lottoResult.getPrizeResult().get(rank);

            if (rank.getInfo(cnt).isBlank()) {
                continue;
            }
            System.out.println(rank.getInfo(cnt));
        }
        System.out.printf(INVESTMENT, lottoResult.calculateInvestment(paymentInput));
    }

    public static void printLottoSize(int size) {
        System.out.printf(LOTTO_COUNT, size);
    }
}
