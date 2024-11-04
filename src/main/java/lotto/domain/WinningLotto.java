package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.WinningLottoValidator;

public class WinningLotto {
    private final List<Integer> winningNumbers;

    public WinningLotto(String input) {
        List<Integer> parsedNumbers = parseInput(input);
        WinningLottoValidator.validate(parsedNumbers);
        Collections.sort(parsedNumbers);
        this.winningNumbers = parsedNumbers;
    }

    private List<Integer> parseInput(String input) {
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
