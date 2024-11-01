package lotto.view;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String LOTTO_FRAME = "[{0}]";
    private static final String DELIMITER_NUMBER = ", ";
    private static final String BUY_LOTTO_COUNT_MESSAGE = NEXT_LINE + "{0}개를 구매했습니다.";

    public static void printLottoTicketInformation(List<List<Integer>> lottos, int lottoCount) {
        System.out.println(MessageFormat.format(BUY_LOTTO_COUNT_MESSAGE, lottoCount));
        lottos.forEach(numbers -> System.out.println(formatLottoNumbers(numbers)));
        System.out.print(NEXT_LINE);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return MessageFormat.format(LOTTO_FRAME, numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER_NUMBER)));
    }
}
