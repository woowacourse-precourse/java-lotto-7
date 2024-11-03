package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.dto.WinningDto;
import lotto.eunm.WinningResult;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계";
    private static final String MATCH_COUNT_MESSAGE = "개 일치";
    private static final String MATCH_WITH_BONUS_MESSAGE = "개 일치, 보너스 볼 일치";
    private static final String WON = "원";
    private static final String COUNT_SUFFIX = "개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String SEPARATOR = "---";
    private static final String RESULT_FORMAT_PATTERN = "%d%s (%s%s) - %d%s%n";

    public void buyOutput(int price, List<Lotto> lottoNumber) {
        System.out.println(price + PURCHASE_MESSAGE);
        buyNumbersOutput(lottoNumber);
    }

    public void winningStatisticsOutput(WinningDto winningDto) {
        System.out.println(RESULT_HEADER);
        System.out.println(SEPARATOR);
        printWinningStatistics(winningDto);
        System.out.printf(TOTAL_PROFIT_MESSAGE, winningDto.getPrice());
    }

    private void buyNumbersOutput(List<Lotto> lottoNumber) {
        lottoNumber.stream()
                .map(Lotto::getSortNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printWinningStatistics(WinningDto winningDto) {
        winningDto.getWinningCount().forEach((matchedCount, count) -> {
            String matchMessage = getMatchMessage(matchedCount);
            System.out.printf(RESULT_FORMAT_PATTERN,
                    matchedCount.winningCount,
                    matchMessage,
                    matchedCount.getFormattedPrizeMoney(),
                    WON,
                    count,
                    COUNT_SUFFIX
            );
        });
    }

    private static String getMatchMessage(WinningResult matchedCount) {
        String matchMessage = MATCH_COUNT_MESSAGE;
        if (matchedCount.equals(WinningResult.FIVE_AND_BONUS)) {
            matchMessage = MATCH_WITH_BONUS_MESSAGE;
        }
        return matchMessage;
    }

}
