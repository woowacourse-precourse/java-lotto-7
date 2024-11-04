package lotto.Utils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import lotto.Domain.Lottos;
import lotto.Domain.WinningResult;
import lotto.Domain.WinningRules;
import lotto.Messages.OutputMessage;

public class Formatter {

    public static String formatLottoCount(Lottos lottos) {
        return String.format(OutputMessage.PURCHASED_LOTTO_COUNT_MESSAGE.getMessage(), lottos.getLottosCount());
    }

    public static List<String> formatLottos(Lottos lottos) {
        List<String> formattedLottos = new ArrayList<>();

        List<Lotto> lottoList = lottos.getLottoList();
        for (int i = 0; i < lottos.getLottosCount(); i++) {
            formattedLottos.add(formatLotto(lottoList.get(i)));
        }

        return formattedLottos;
    }

    public static String formatLotto(Lotto lotto) {
        StringBuilder result = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();

        result.append(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));

        return result.toString();
    }

    public static List<String> formatWinningStatistics(WinningResult winningResult) {
        List<String> formattedStatistics = new ArrayList<>();

        formattedStatistics.add(OutputMessage.WINNING_STATISTICS_HEADER.getMessage());
        formattedStatistics.add(OutputMessage.WINNING_STATISTICS_SEPARATOR.getMessage());

        for (WinningRules rule : WinningRules.values()) {
            if (rule == WinningRules.NO_WIN) {
                continue;
            }
            String message = formatWinningRule(rule, winningResult.getCount(rule));
            formattedStatistics.add(message);
        }

        return formattedStatistics;
    }

    private static String formatWinningRule(WinningRules rule, int count) {
        String prize = NumberFormat.getInstance().format(rule.getPrize());
        if (rule == WinningRules.SECOND) {
            return String.format(OutputMessage.WINNING_STATISTICS_SECOND.getMessage(),
                    rule.getMatchCount(), prize, count);
        }
        return String.format(OutputMessage.WINNING_STATISTICS.getMessage(),
                rule.getMatchCount(), prize, count);
    }

}
