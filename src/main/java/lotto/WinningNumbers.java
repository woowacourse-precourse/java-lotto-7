package lotto;

import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = splitWinningNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validate(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_LOTTO_NUMBER_COUNT.getText());
        }
        List<Integer> parsedNumbers = splitWinningNumbers(winningNumbers);
        if (parsedNumbers.size() != LottoRange.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_LOTTO_NUMBER_COUNT.getText());
        } else if (new HashSet<>(parsedNumbers).size() != LottoRange.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getText());
        } else if (!isNumbersInRange(parsedNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_RANGE.getText());
        }
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbers.split(Delimiter.COMMA.getDelimiter())) {
            try {
                parsedNumbers.add(Integer.parseInt(winningNumber.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getText() + winningNumber);
            }
        }
        return parsedNumbers;
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (LottoRange.MIN.getValue() > number || number > LottoRange.MAX.getValue()) {
                return false;
            }
        }
        return true;
    }
}
