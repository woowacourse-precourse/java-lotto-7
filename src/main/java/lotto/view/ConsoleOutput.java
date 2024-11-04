package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.configuration.Prize;
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

        Map<Prize, Integer> completePrizeMap = getCompletePrizeMap(input);
        printPrizeStatistics(completePrizeMap);
        printProfitRate(input.profitRate());
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        ConsoleUtils.printFormattedMessage(PURCHASED_LOTTO_COUNT_FORMAT, lottos.size());
        lottos.forEach(lotto -> ConsoleUtils.printMessageWithNewLine(
                lotto.getNumbers().stream().sorted().toList().toString()
        ));
    }

    public void printException(Exception e) {
        ConsoleUtils.printError(e.getMessage());
    }

    // private methods

    private Map<Prize, Integer> getCompletePrizeMap(ProfitStatisticsDto input) {
        return Arrays.stream(Prize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> input.prizeCountMap().getOrDefault(prize, 0)));
    }

    private void printPrizeStatistics(Map<Prize, Integer> completePrizeMap) {
        Arrays.stream(Prize.values())
                .sorted(Comparator.comparingInt(Prize::getPrizeMoney))
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> {
                    String outMessage = formatPrizeMessage(prize, completePrizeMap.get(prize));
                    ConsoleUtils.printMessageWithNewLine(outMessage);
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
