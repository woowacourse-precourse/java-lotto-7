package lotto.view;

import java.util.List;
import lotto.configuration.Prize;
import lotto.dto.PrizeCountEntry;
import lotto.dto.ProfitStatisticsDto;
import lotto.entity.Lotto;

public class ConsoleOutput {
    public static final String STATISTIC_TITLE = "당첨 통계";
    public static final String DVIDER_STRING = "---";

    public static final String PURCHASED_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.%n";
    public static final String BONUS_MATCH_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    public static final String MATCH_FORMAT = "%d개 일치 (%,d원) - %d개";
    public static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";

    // public methods

    public void printProfitStatistics(ProfitStatisticsDto input) {
        ConsoleUtils.printNewLine();
        ConsoleUtils.printMessageWithNewLine(STATISTIC_TITLE);
        ConsoleUtils.printMessageWithNewLine(DVIDER_STRING);

        printPrizeStatistics(input.prizeCountEntries());
        printProfitRate(input.profitRate());
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        ConsoleUtils.printFormattedMessage(PURCHASED_LOTTO_COUNT_FORMAT, lottos.size());
        lottos.forEach(lotto -> ConsoleUtils.printMessageWithNewLine(
                lotto.getNumbers().stream().toList().toString()
        ));
    }

    public void printException(Exception e) {
        ConsoleUtils.printError(e.getMessage());
    }

    // private methods

    private void printPrizeStatistics(List<PrizeCountEntry> prizeCountEntries) {
        prizeCountEntries.stream()
                .filter(prizeCountEntry -> prizeCountEntry.prize() != Prize.NONE)
                .forEach(prizeCountEntry -> {
                    String formatPrizeMessage = formatPrizeMessage(prizeCountEntry.prize(), prizeCountEntry.count());
                    ConsoleUtils.printMessageWithNewLine(formatPrizeMessage);
                });
    }

    private String formatPrizeMessage(Prize prize, int count) {
        if (prize == Prize.SECOND) {
            return String.format(BONUS_MATCH_FORMAT,
                    prize.getMatchCount(), prize.getPrizeMoney(), count);
        }
        return String.format(MATCH_FORMAT, prize.getMatchCount(), prize.getPrizeMoney(), count);
    }

    private void printProfitRate(double profitRate) {
        ConsoleUtils.printFormattedMessage(PROFIT_RATE_FORMAT, profitRate);
    }

}
