package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.common.Constants.*;
import static lotto.common.ValidationUtils.*;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(String inputWinningNumbers) {
        this.winningNumbers = getWinningNumbers(inputWinningNumbers);
        this.bonusNumber = null;
    }

    private List<Integer> getWinningNumbers (String inputWinningNumbers) {
        List<String> rawWinningNumbers = List.of(inputWinningNumbers.split(WINNING_NUMBERS_DELIMITER));

        List<Integer> winningNumbers = new ArrayList<>();

        for (String rawWinningNumber : rawWinningNumbers) {
            validateWinningNumber(rawWinningNumber, winningNumbers);

            Integer winningNumber = Integer.parseInt(rawWinningNumber);
            winningNumbers.add(winningNumber);
        }

        validateSize(winningNumbers, LOTTO_SIZE, INVALID_LOTTO_SIZE);

        return winningNumbers;
    }

    private void validateWinningNumber (String rawWinningNumber, List<Integer> winningNumbers) {

        validateNumber(rawWinningNumber, INVALID_WINNING_NUMBER);
        validateInRange(rawWinningNumber, MIN_WINNING_NUMBER, MAX_WINNING_NUMBER, INVALID_WINNING_NUMBER);

        Integer winningNumber = Integer.parseInt(rawWinningNumber);

        validateDuplicatedNumber(winningNumbers, winningNumber, INVALID_DUPLICATE_WINNING_NUMBER);
    }

    public boolean compareNumbers(List<Integer> winningNumbers) {
        return Objects.equals(this.winningNumbers, winningNumbers);
    }
}
