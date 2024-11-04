package lotto.domain;

import static lotto.utils.Constant.COMMA;
import static lotto.utils.Constant.LOTTO_SIZE;

import global.errorMessage.NumberErrorMessage;
import global.errorMessage.WinningNumberErrorMessage;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validateFormat(winningNumbers);
        validateWinningNumbers(winningNumbers);
        List<Integer> sortedWinningNumbers = convertToListAndSort(winningNumbers);
        this.winningNumbers = Collections.unmodifiableList(sortedWinningNumbers);
    }

    public int countMatchingNumbers(Lotto lotto) {
        Set<Integer> winningset = new HashSet<>(winningNumbers);
        int count = 0;
        for(int i=0;i<LOTTO_SIZE;i++){
            Integer number = lotto.getElement(i);
            if(winningset.contains(number)){
                count++;
            }
        }
        return count;
    }

    private void validateFormat(String winningNumbers) {
        if(winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
        if(winningNumbers.startsWith(COMMA) || winningNumbers.endsWith(COMMA)) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateWinningNumbers(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(COMMA);
        if(splitWinningNumbers.length != 6) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
        int number;
        for (String splitWinningNumber : splitWinningNumbers) {
            try {
                number = Integer.parseInt(splitWinningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
            }
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(NumberErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private List<Integer> convertToListAndSort(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
