package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validator.InputValidator.hasNoDuplicates;
import static lotto.validator.InputValidator.nonEmpty;


public class WinningNumbersValidator {
    private List<String> winningNumbers;

    public WinningNumbersValidator() {
        winningNumbers = new LinkedList<>();
    }

    public List<String> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> convertTypeSetNumbers() {
        processSetWinningNumbers();

        return winningNumbers.stream()
                             .map(Integer::parseInt)
                             .collect(Collectors.toList());
    }

    private void processSetWinningNumbers() {
        InputUtils.retryRequest(Input.request(Input.PURCHASE_AMOUNT_PROMPT),
                request -> {
                    if (winningNumbersValidation(request)) {
                        this.winningNumbers = removeEmpty(divideString(request));

                        return isSixWinningNumbers(winningNumbers) &&
                               hasNoDuplicates(Input.PURCHASE_AMOUNT_PROMPT, winningNumbers) &&
                               isLottoNumberRange(winningNumbers);
                    }
                    return false;
                }
        );
    }

    private Boolean winningNumbersValidation(String request) {

        return nonEmpty(Input.WINNING_NUMBERS_PROMPT, request) &&
               isRegexCheck(request);
    }


    private Boolean isRegexCheck(String input) {
        if (input.matches("^,*(-?\\d+,*)*$")) {
            return true;
        }

        throw new RetryInputException(Input.WINNING_NUMBERS_PROMPT, ErrorMessages.INVALID_FORMAT.getMessage());
    }

    private List<String> divideString(String input) {

        return Arrays.asList(input.split(","));
    }

    private List<String> removeEmpty(List<String> numbers) {
        numbers.removeIf(String::isEmpty);
        return numbers;
    }

    private Boolean isSixWinningNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() == LottoConstants.SIX_PICK) {
            return true;
        }

        throw new RetryInputException(Input.PURCHASE_AMOUNT_PROMPT,
                ErrorMessages.INVALID_WINNING_NUMBERS_COUNT.getMessage());
    }

    private Boolean isLottoNumberRange(List<String> winningNumbers) {
        winningNumbers.forEach(number -> {

            if (Integer.parseInt(number) < LottoConstants.MIN_BALL ||
                Integer.parseInt(number) > LottoConstants.MAX_BALL) {

                throw new RetryInputException(Input.WINNING_NUMBERS_PROMPT,
                        ErrorMessages.IS_OUT_OF_LOTTO_NUMBER.getMessage());
            }
        });

        return true;
    }

}


