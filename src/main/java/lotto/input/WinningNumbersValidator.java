package lotto.input;

import lotto.enums.ErrorMessages;

import java.util.*;

import static lotto.enums.ErrorMessages.*;
import static lotto.enums.LottoConstants.*;
import static lotto.enums.PromptMessages.WINNING_NUMBERS_PROMPT_MESSAGE;

public class WinningNumbersValidator implements InputValidator<List<Integer>, Void> {

    private final static String DELIMITER = ",";

    @Override
    public List<Integer> validateInput(String input, Void unused) {
        validateWinningNumberDelimiter(input);
        List<Integer> lottoWinningNumber = splitInputByComma(input);

        validateWinningNumberRange(lottoWinningNumber);
        validateWinningNumberSize(lottoWinningNumber);
        validateWinningNumberDuplication(lottoWinningNumber);

        return lottoWinningNumber;
    }

    @Override
    public void displayPrompt() {
        System.out.println(WINNING_NUMBERS_PROMPT_MESSAGE.getMessage());
    }

    private void validateWinningNumberDelimiter(String input) {
        if (!input.matches("[0-9,]*")) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DELIMITER.getMessage());
        }
    }

    private void validateWinningNumberRange(List<Integer> winningNumber) throws IllegalArgumentException {
        if (winningNumber.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateWinningNumberSize(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_WINNING_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateWinningNumberDuplication(List<Integer> winningNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumber);

        if(winningNumber.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private List<Integer> splitInputByComma(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(Integer::parseInt).toList();
    }


}
