package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class WinningNumbers extends Validator implements LottoConstants {
    private Set<Integer> winningNumbers = new TreeSet<>();

    public WinningNumbers() {
        processSetWinningNumbers();
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void processSetWinningNumbers() {
        String request = InputUtils.retryRequest(Input.request(Input.WINNING_NUMBERS_PROMPT), this::validate);

        this.winningNumbers = convertType(removeEmpty(divide(request)));
    }

    @Override
    public Boolean validate(String request) {
        Set<Integer> winningNumbers;

        if (nonEmpty(Input.WINNING_NUMBERS_PROMPT, request) && isRegexCheck(request)) {
            winningNumbers = convertType(removeEmpty(divide(request)));

            winningNumbers.forEach(number ->
                    isLottoNumberRange(Input.PURCHASE_AMOUNT_PROMPT, number));

            return isSixWinningNumbers(winningNumbers) &&
                   hasNoDuplicates(Input.WINNING_NUMBERS_PROMPT, winningNumbers);
        }

        return false;
    }

    private Set<Integer> convertType(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                     .map(Integer::parseInt)
                     .collect(Collectors.toSet());
    }


    private Boolean isRegexCheck(String input) {
        if (input.matches("^,*(-?\\d+,*)*$")) {
            return true;
        }

        throw new RetryInputException(Input.WINNING_NUMBERS_PROMPT, ErrorMessages.INVALID_FORMAT.getMessage());
    }

    private String[] divide(String input) {
        return input.split(",");
    }

    private String[] removeEmpty(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                     .filter(str -> !str.isEmpty())
                     .toArray(String[]::new);
    }

    private Boolean isSixWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() == SIX_PICK) {
            return true;
        }

        throw new RetryInputException(Input.WINNING_NUMBERS_PROMPT,
                ErrorMessages.INVALID_WINNING_NUMBERS_COUNT.getMessage());
    }

}


