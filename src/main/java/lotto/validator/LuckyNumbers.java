package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.util.InputUtils;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LuckyNumbers extends Validator {
    private List<Integer> luckyNumbers = new ArrayList<>();

    public List<Integer> getLuckyNumbers() {
        return new ArrayList<>(luckyNumbers);
    }

    public LuckyNumbers processSetWinningNumbers() {
        String request = InputUtils.retryRequest(Input.request(Input.WINNING_NUMBERS_PROMPT), this::validate);
        this.luckyNumbers = convertType(removeEmpty(divide(request)));

        return this;
    }

    @Override
    public Boolean validate(String request) {
        List<Integer> numbers;

        if (nonEmpty(Input.WINNING_NUMBERS_PROMPT, request) && isRegexCheck(request)) {
            numbers = convertType(removeEmpty(divide(request)));

            numbers.forEach(number ->
                    isLottoNumberRange(Input.WINNING_NUMBERS_PROMPT, number));

            return isSixWinningNumbers(numbers) &&
                   hasNoDuplicates(Input.WINNING_NUMBERS_PROMPT, numbers);
        }

        return false;
    }

    private List<Integer> convertType(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
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

    private Boolean isSixWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() == SIX_PICK) {
            return true;
        }

        throw new RetryInputException(Input.WINNING_NUMBERS_PROMPT,
                ErrorMessages.INVALID_LUCKY_NUMBERS_COUNT.getMessage());
    }

}


