package lotto.parser;

import static lotto.constants.ErrorMessages.*;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;

import lotto.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersParser {

    public static List<Integer> parse(String input) {
        String[] inputs = input.split(",");
        if (inputs.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_COUNT);
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputs) {
            int num = parseNumber(number.trim());
            LottoNumberValidator.validateRange(num);
            if (winningNumbers.contains(num)) {
                throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATE);
            }
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_NUMERIC);
        }
    }
}
