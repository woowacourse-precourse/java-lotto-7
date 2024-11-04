package lotto.view;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String NUMBERS_MESSAGE_FORMAT = "[%s]\n";
    private static final String STATISTIC_MESSAGE_FORMAT = "%d개 일치%s (%s원) - %d개\n";

    private static final String DEFAULT_BONUS_NUMBER_MESSAGE = "";
    private static final String BONUS_NUMBER_NEEDED_MESSAGE = ", 보너스 볼 일치";
    private static final String STATISTIC_TITLE = "당첨 통계";

    private static final String DEFAULT_DECIMAL_FORMAT = "#,##0.##";
    private static final String STATISTIC_CONTENT_DELIMITER = "---";
    private static final String NUMBERS_FORMAT_DELIMITER = ", ";

    public void displayPurchases(List<Lotto> purchases) {
        displayPurchaseCount(purchases.size());
        for (Lotto lotto : purchases) {
            displayNumbers(lotto);
        }
    }

    public void displayWinningStatistic(Map<Prize, Integer> winningResult) {
        System.out.println(STATISTIC_TITLE);
        System.out.println(STATISTIC_CONTENT_DELIMITER);
        winningResult.entrySet().stream()
                .filter(entry -> entry.getKey() != Prize.UNRANKED)
                .sorted(Comparator.comparing(entry -> entry.getKey().getMatchCount()))
                .forEach(this::displayEachStatistic);
    }

    private void displayEachStatistic(Entry<Prize, Integer> entry) {
        String isBonusNumberNeeded = DEFAULT_BONUS_NUMBER_MESSAGE;
        if (entry.getKey().isBonusRequired()) {
            isBonusNumberNeeded = BONUS_NUMBER_NEEDED_MESSAGE;
        }

        Integer matchCount = entry.getKey().getMatchCount();
        String prizeAmount = new DecimalFormat(DEFAULT_DECIMAL_FORMAT).format(entry.getKey().getPrizeAmount());
        Integer winningCount = entry.getValue();

        System.out.printf(STATISTIC_MESSAGE_FORMAT, matchCount, isBonusNumberNeeded, prizeAmount, winningCount);
    }


    private void displayPurchaseCount(Integer count) {
        System.out.printf(PURCHASE_COUNT_MESSAGE_FORMAT, count);
    }

    private void displayNumbers(Lotto lotto) {
        List<String> numbers = lotto.getNumbers().stream().map(String::valueOf).toList();

        System.out.printf(NUMBERS_MESSAGE_FORMAT, String.join(NUMBERS_FORMAT_DELIMITER, numbers));
    }
}
