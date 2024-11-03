package lotto.service.generator;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.factory.LottoFactory;
import lotto.message.ExceptionMessage;
import lotto.util.NumberValidator;

public class WinningGenerator {

    private static final String WINNING_SEPARATOR = ",";
    private static final Integer SPLIT_LIMIT = -1;

    private final List<Integer> winning;

    public WinningGenerator(String winning) {
        validate(winning);
        this.winning = changeType(winning);
    }

    private boolean IsContainSeparator(String winning) {
        return !winning.contains(WINNING_SEPARATOR);
    }

    private void validate(String winning) {
        if (IsContainSeparator(winning)) {
            throw new LottoException(ExceptionMessage.INPUT_LOTTO_SEPARATOR_EXCEPTION);
        }
    }

    private List<String> split(String winning) {
        return Arrays.stream(winning.split(WINNING_SEPARATOR, SPLIT_LIMIT)).toList();
    }

    private List<Integer> changeType(String winning) {
        return split(winning).stream()
                .map(NumberValidator::change)
                .toList();
    }

    public Lotto getWinning() {
        return LottoFactory.create(winning);
    }
}
