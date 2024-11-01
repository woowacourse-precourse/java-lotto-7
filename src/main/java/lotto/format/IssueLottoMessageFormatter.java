package lotto.format;

import lotto.domain.IssueLotto;
import lotto.domain.Lotto;

import static java.util.stream.Collectors.joining;
import static lotto.message.OutputMessage.BASIC_DELIMITER;
import static lotto.message.OutputMessage.NEW_LINE;

public class IssueLottoMessageFormatter implements MessageFormatter<IssueLotto> {

    private static final String STRAT_PREFIX = "[";
    private static final String END_SUFFIX = "]";

    @Override
    public String format(IssueLotto target) {
        return target.getLottos().stream()
                .map(this::formatMessage)
                .collect(joining(NEW_LINE));
    }

    private String formatMessage(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(joining(BASIC_DELIMITER, STRAT_PREFIX, END_SUFFIX));
    }
}
