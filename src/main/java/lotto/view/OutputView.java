package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.message.OutputMessage;
import lotto.model.domain.Lotto;
import lotto.model.dto.LottoStatisticsResponse;
import lotto.model.dto.LottosResponse;

public class OutputView {

    public static void printCustomerLottos(LottosResponse response) {
        List<Lotto> lottos = response.lottos();
        printBlankLine();
        System.out.println(lottos.size() + OutputMessage.PURCHASE_COUNT.getMessage());
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningStatistics(LottoStatisticsResponse response) {
        printBlankLine();
        System.out.println(OutputMessage.WINNING_STATISTICS_HEADER.getMessage());
        System.out.println(OutputMessage.WINNING_STATISTICS_DIVIDER.getMessage());

        printMatchStatistics("3", response);
        printMatchStatistics("4", response);
        printMatchStatistics("5", response);
        printMatchStatistics("5B", response);
        printMatchStatistics("6", response);

        DecimalFormat df = new DecimalFormat("#,##0.0");
        String formattedRateOfRevenue = df.format(response.rateOfRevenue());
        System.out.printf(OutputMessage.REVENUE_RATE.getMessage(), formattedRateOfRevenue);
    }

    private static void printMatchStatistics(String matchCountKey, LottoStatisticsResponse response) {
        int count = response.statistics().getOrDefault(matchCountKey, 0);
        String messageFormat = getMatchMessageFormat(matchCountKey);
        System.out.printf((messageFormat) + "%n", count);
    }

    private static String getMatchMessageFormat(String matchCountKey) {
        return switch (matchCountKey) {
            case "3" -> OutputMessage.MATCH_3.getMessage();
            case "4" -> OutputMessage.MATCH_4.getMessage();
            case "5" -> OutputMessage.MATCH_5.getMessage();
            case "5B" -> OutputMessage.MATCH_5_BONUS.getMessage();
            case "6" -> OutputMessage.MATCH_6.getMessage();
            default -> throw new IllegalArgumentException("[ERROR] 잘못된 키입니다.");
        };
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
