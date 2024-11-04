package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.validator.WinningLottoValidator;

public class WinningLotto {
    private static final String NUMBER_DELIMITER = ",";
    private static final String WINNING_LOTTO_REGEX = "^[0-9,]+$";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(String winningNumberInput, String bonusNumberInput) {
        List<Integer> parsedWinningNumbers = parseWinningNumbers(winningNumberInput);
        int parsedBonusNumber = parseBonusNumber(bonusNumberInput);

        WinningLottoValidator.validate(parsedWinningNumbers, parsedBonusNumber);

        this.winningNumbers = parsedWinningNumbers;
        this.bonusNumber = parsedBonusNumber;
    }

    private List<Integer> parseWinningNumbers(String input) {
        if (!input.matches(WINNING_LOTTO_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표만 포함할 수 있습니다.");
        }
        try {
            return Stream.of(input.split(NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private int parseBonusNumber(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
