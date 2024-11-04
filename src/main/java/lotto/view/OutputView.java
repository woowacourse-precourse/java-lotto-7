package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDING_MESSAGE = "---";
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_RANK_FORMAT = "%s (%,d원) - %d개";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.";


    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.printf((PURCHASE_COUNT_FORMAT) + "%n", count);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(i -> System.out.println(i.getNumbers()));
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_MESSAGE);

        Arrays.stream(Rank.values())
                .forEach(rank -> printRankCount(rank, lottoResult.getCountByRank(rank)));

        System.out.printf(RETURN_RATE_FORMAT + "%n", lottoResult.getReturnRate());
    }

    private void printRankCount(Rank rank, int count) {
        if(rank == Rank.NONE) {
            return;
        }

        System.out.printf((WINNING_RANK_FORMAT) + "%n",
                rank.getDescription(),
                rank.getPrize(),
                count);
    }

    public void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printWinningNumbersMessage() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
