package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.dto.LottoNumberDto;
import lotto.enums.Rank;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_NUMBER_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String MATCH_RESULT_MESSAGE = "%s (%s원) - %d개%n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final long DEFAULT_COUNT = 0L;

    private OutputView() {
    }

    public static void printPurchaseAmountInputMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseLottoNumbers(List<LottoNumberDto> purchasedLottoNumbers) {
        System.out.printf(PURCHASE_NUMBER_MESSAGE + "%n", purchasedLottoNumbers.size());

        purchasedLottoNumbers.forEach(lottoNumberDto ->
                System.out.println(lottoNumberDto.numbers())
        );

    }

    public static void printStatistics(Map<Rank, Long> statistics, double profitRate) {
        System.out.println(STATISTICS_HEADER);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() >= 3) {
                long count = statistics.getOrDefault(rank, DEFAULT_COUNT);
                String formattedPrize = numberFormat.format(rank.getPrize());
                System.out.printf(MATCH_RESULT_MESSAGE, rank.getDescription(), formattedPrize, count);
            }
        }
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    public static void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
