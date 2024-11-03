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

    // public methods

    public void printProfitStatistics(ProfitStatisticsDto input) {
        ConsoleUtils.printNewLine();
        ConsoleUtils.printMessageWithNewLine("당첨 통계");
        ConsoleUtils.printMessageWithNewLine("---");

        Map<Prize, Integer> completePrizeMap = getCompletePrizeMap(input);
        printPrizeStatistics(completePrizeMap);
        printProfitRate(input.getProfitRate());
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        ConsoleUtils.printFormattedMessage("%d개를 구매했습니다.%n", lottos.size());
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
                .collect(Collectors.toMap(prize -> prize, prize -> input.getPrizeCountMap().getOrDefault(prize, 0)));
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
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                    prize.getMatchCount(), prize.getPrizeMoney(), count);
        }
        return String.format("%d개 일치 (%,d원) - %d개", prize.getMatchCount(), prize.getPrizeMoney(), count);
    }

    private void printProfitRate(double profitRate) {
        ConsoleUtils.printFormattedMessage("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
