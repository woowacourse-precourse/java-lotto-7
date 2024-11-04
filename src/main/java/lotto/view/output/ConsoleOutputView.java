package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;

public class ConsoleOutputView implements OutputView {
    private static final String INPUT_PURCHASE_GUIDE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_FORMAT = "%d개를 구매했습니다.";

    private static final String WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";

    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";

    private static final String FIFTH_PLACE_FORMAT = "3개 일치 (5,000원) - %d개%n";
    private static final String FOURTH_PLACE_FORMAT = "4개 일치 (50,000원) - %d개%n";
    private static final String THIRD_PLACE_FORMAT = "5개 일치 (1,500,000원) - %d개%n";
    private static final String SECOND_PLACE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    private static final String FIRST_PLACE_FORMAT = "6개 일치 (2,000,000,000원) - %d개%n";

    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private static final String BRACKET_OPEN = "[";
    private static final String BRACKET_CLOSE = "]";

    @Override
    public void printPurchaseGuide() {
        System.out.println(INPUT_PURCHASE_GUIDE);
    }

    @Override
    public void printPurchasedAmount(int count) {
        System.out.printf(PURCHASE_RESULT_FORMAT, count);
    }

    @Override
    public void printLottoTicket(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.print(BRACKET_OPEN);
            System.out.print(lotto);
            System.out.println(BRACKET_CLOSE);
        }
        System.out.println();
    }

    @Override
    public void printWinningNumbersGuide() {
        System.out.println(WINNING_NUMBERS_GUIDE);
    }

    @Override
    public void printBonusNumberGuide() {
        System.out.println(BONUS_NUMBER_GUIDE);
    }

    @Override
    public void printWinningStatistics() {
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);
    }

    @Override
    public void printWinningResult(Map<Rank, Integer> rankCount) {
        System.out.printf(FIFTH_PLACE_FORMAT, rankCount.get(Rank.FIFTH));
        System.out.printf(FOURTH_PLACE_FORMAT, rankCount.get(Rank.FOURTH));
        System.out.printf(THIRD_PLACE_FORMAT, rankCount.get(Rank.THIRD));
        System.out.printf(SECOND_PLACE_FORMAT, rankCount.get(Rank.SECOND));
        System.out.printf(FIRST_PLACE_FORMAT, rankCount.get(Rank.FIRST));
    }

    @Override
    public void printProfitRate(double rate) {
        System.out.printf(PROFIT_RATE_FORMAT, rate);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
