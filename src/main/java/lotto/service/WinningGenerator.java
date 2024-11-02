package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.Factory.LottoFactory;
import lotto.domain.Lotto;

public class WinningGenerator {

    private static final String WINNING_SEPARATOR = ",";
    private static final Integer SPLIT_LIMIT = -1;

    private final Lotto winning;

    public WinningGenerator(String winning) {
        validate(winning);
        this.winning = LottoFactory.create(changeType(winning));
    }

    private boolean IsContainSeparator(String winning) {
        return !winning.contains(WINNING_SEPARATOR);
    }

    private void validate(String winning) {
        if (IsContainSeparator(winning)) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> split(String winning) {
        return Arrays.stream(winning.split(WINNING_SEPARATOR, SPLIT_LIMIT)).toList();
    }

    private List<Integer> changeType(String winning) {
        return split(winning).stream()
                .map(Integer::parseInt)
                .toList();
    }

    public Lotto getWinning() {
        return winning;
    }
}
