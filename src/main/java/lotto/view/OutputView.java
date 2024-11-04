package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.EarnedLotto;
import lotto.dto.EarnedLottos;
import lotto.dto.WinningStatistics;
import lotto.model.WinningType;

public class OutputView {
    private static final String LOTTO_INFORMATION_PREFIX = "[";
    private static final String LOTTO_INFORMATION_SUFFIX = "]";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";
    private static final DecimalFormat formatter = new DecimalFormat("#,###");
    public void printLottoNumbers(EarnedLottos dto) {
        System.out.printf(OutputViewMessage.LOTTO_BUY_COUNT_MESSAGE.getMessage(), dto.lottosDto().size());
        dto.lottosDto().forEach(this::printLottoDto);
    }

    public void printExceptionMessage(final Exception e) {
        System.out.println(e.getMessage());
    }

    public void printWinningHistory(final WinningStatistics statistics) {
        System.out.println(OutputViewMessage.WINNING_STATISTICS_START_MESSAGE.getMessage());
        Stream.of(WinningType.values())
                .filter(WinningType::isNotNone)
                .forEach(winningType -> {
                    int winningCount = statistics.getWinningCount(winningType);
                    printWinningType(winningType, winningCount);
                });

        };
    private void printWinningType(WinningType type, int winningCount) {
        System.out.printf(OutputViewMessage.WINNING_STATISTICS.getMessage(),
                type.getMatchCount(),
                getMatchBonus(type),
                getFormattedPrize(type),
                winningCount);
    }

    private String getMatchBonus(WinningType type) {
        if (type.getMatchBonus()) {
            return OutputViewMessage.BONUS_MATCH.getMessage();
        }
        return OutputViewMessage.EMPTY_STRING.getMessage();
    }

    private String getFormattedPrize(WinningType type) {
        return formatter.format(type.getPrize());
    }

    private void printLottoDto(EarnedLotto earnedLotto) {
        StringBuilder sb = new StringBuilder(LOTTO_INFORMATION_PREFIX);
        List<String> list = earnedLotto.numbers().stream().map(String::valueOf).toList();
        sb.append(String.join(LOTTO_NUMBER_SEPARATOR, list));
        sb.append(LOTTO_INFORMATION_SUFFIX);
        System.out.println(sb);
    }

}
