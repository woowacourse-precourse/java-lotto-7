package lotto.view;

import static lotto.view.constants.ViewMessage.OUTPUT_LOTTO_PURCHASE_AMOUNT;
import static lotto.view.constants.ViewMessage.OUTPUT_LOTTO_RESULT_BODY;
import static lotto.view.constants.ViewMessage.OUTPUT_LOTTO_RESULT_BONUS_BODY;
import static lotto.view.constants.ViewMessage.OUTPUT_LOTTO_RESULT_HEADER;
import static lotto.view.constants.ViewMessage.OUTPUT_TOTAL_PROFIT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.constants.Rank;

public class OutputView {

    public static void printLottos(final List<Lotto> lottos) {
        System.out.println();
        System.out.printf(OUTPUT_LOTTO_PURCHASE_AMOUNT.getMessage(), lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottoResult(final LottoResult result) {
        System.out.println();
        System.out.println(OUTPUT_LOTTO_RESULT_HEADER.getMessage());

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            System.out.println(formatLottoResultMessage(rank, result));
        }
        System.out.println(formatTotalProfitMessage(result.calculateYield()));
    }

    private static String formatLottoResultMessage(final Rank rank, final LottoResult result) {
        String prizeFormatted = String.format("%,d", rank.getPrize());
        String lottoResultMessage = String.format(OUTPUT_LOTTO_RESULT_BODY.getMessage(),
                rank.getMatchCount(), prizeFormatted, result.getCount(rank));

        if (rank == Rank.SECOND) {
            lottoResultMessage = String.format(OUTPUT_LOTTO_RESULT_BONUS_BODY.getMessage(),
                    rank.getMatchCount(), prizeFormatted, result.getCount(rank));
        }
        return lottoResultMessage;
    }

    private static String formatTotalProfitMessage(final Double yield) {
        return String.format(OUTPUT_TOTAL_PROFIT.getMessage(), yield);
    }
}
