package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Number> winningNumbers;

    public WinningNumbers(String numbers) {
        this.winningNumbers = createWinningNumbers(numbers);
    }

    private List<Number> createWinningNumbers(String numbers) {
        return LottoNumberParser.parse(numbers);
    }
}
