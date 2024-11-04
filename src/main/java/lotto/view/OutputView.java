package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String PICK_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_HEADER = "\n당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printLottoResult(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + PURCHASED_LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printPickNumberInputMessage() {
        System.out.println(PICK_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoCounts(Map<LottoRank, Long> lottoCounts) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(SEPARATOR);
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NON_MATCHES) {
                continue;
            }
            long count = lottoCounts.getOrDefault(rank, 0L);
            System.out.printf("%s - %d개%n", rank.getDescription(), count);
        }
    }

    public void printProfitRate(double profit) {
        System.out.printf(PROFIT_RATE_MESSAGE, profit);
    }
}
