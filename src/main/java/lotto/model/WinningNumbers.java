package lotto.model;

import lotto.exception.InvalidWinningNumbersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER_IS_NOT_ALLOWED;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.model.Lotto.MIN_LOTTO_NUMBER;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(String winningString) {
        createLottoByWinningString(winningString);
    }

    public List<Integer> get() {
        return winningNumbers;
    }

    private void createLottoByWinningString(String winningString) {
        List<Integer> createdLotto = processingWinningNumbers(winningString);
        checkEachLottoNumberHasValidate(createdLotto);

        winningNumbers = createdLotto;
    }

    private List<Integer> processingWinningNumbers(String winningString) {
        List<String> splitStringByComma = List.of(winningString.split(","));
        List<Integer> processedWinningNumbers = new ArrayList<>();

        for (String string : splitStringByComma) {
            processedWinningNumbers.add(Integer.parseInt(string.trim()));
        }

        return processedWinningNumbers;
    }

    private void checkEachLottoNumberHasValidate(List<Integer> winningNumbers) {
        HashSet<Integer> numbers = new HashSet<>();

        for (int number : winningNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new InvalidWinningNumbersException(INVALID_NUMBER_RANGE.getMessage());
            }

            if (!numbers.add(number)) {
                throw new InvalidWinningNumbersException(DUPLICATE_NUMBER_IS_NOT_ALLOWED.getMessage());
            }
        }
    }
}
