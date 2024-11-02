package lotto.format;

import lotto.domain.LottoIssue;
import lotto.domain.Lotto;

import static java.util.stream.Collectors.joining;
import static lotto.message.SymbolMessage.SYMBOL_BASIC_DELIMITER;
import static lotto.message.SymbolMessage.SYMBOL_NEW_LINE;

public class LottoIssueMessageFormatter implements MessageFormatter<LottoIssue> {

    private static final String STRAT_PREFIX = "[";
    private static final String END_SUFFIX = "]";

    @Override
    public String format(LottoIssue lottoIssue) {
        return lottoIssue.getLottos().stream()
                .map(this::format)
                .collect(joining(SYMBOL_NEW_LINE.message()));
    }

    private String format(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(joining(SYMBOL_BASIC_DELIMITER.message(), STRAT_PREFIX, END_SUFFIX));
    }
}
