package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.PurchasedLottos;

public class OutputView {

    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    public static final String LINE_SEPARATOR = "---";
    public static final String LOTTO_RANK_COUNT_MESSAGE = "%s (%s원) - %d개\n";
    public static final String LOTTO_REVENUE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String THOUSAND_SEPARATOR_FORMAT = "%,d";

    public void showMoneyInputComments() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void showLottoWinningNumbersInputComments() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void showLottoBonusNumberInputComments() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void showPurchasedLottos(int purchasedCount, PurchasedLottos purchasedLottos) {
        System.out.println();
        System.out.printf(LOTTO_PURCHASE_RESULT_MESSAGE, purchasedCount);
        List<Lotto> lottos = purchasedLottos.getLottos();
        lottos.forEach(System.out::println);
    }

    public void showLottoResult(Map<LottoRank, Integer> lottoResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE_SEPARATOR);
        List<LottoRank> orderedRanks = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND,
                LottoRank.FIRST);
        orderedRanks.forEach(rank ->
                System.out.printf(LOTTO_RANK_COUNT_MESSAGE, rank.getMessage(),
                        String.format(THOUSAND_SEPARATOR_FORMAT, rank.getPrizeAmount()),
                        lottoResult.getOrDefault(rank, 0))
        );
    }

    public void showLottoRevenue(double revenue) {
        System.out.printf(LOTTO_REVENUE_MESSAGE, revenue);
    }

    public void showExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
