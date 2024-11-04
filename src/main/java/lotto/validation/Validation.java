package lotto.validation;

import lotto.LottoConstants;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {
    public static Integer validateCash(String input) {
        try {
            Integer cash = Integer.parseInt(input);
            if (cash <= LottoConstants.INPUT_MIN_CASH || cash > LottoConstants.INPUT_MAX_CASH) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_CASH.getMessage());
            }
            if (cash % LottoConstants.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(ErrorMessages.NON_UNIT_CASH.getMessage());
            }
            return cash;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMBER_CASH.getMessage());
        }
    }

    public static Lotto validateLotto(String input) {
        if (!input.matches("(\\d+)(,\\d+)*")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_FORMAT.getMessage());
        }

        List<Integer> numbers = parseIntToInput(input);
        return new Lotto(numbers);
    }

    public static Integer validateBonus(String input) {
        try {
            Integer bonus = Integer.parseInt(input);
            if (bonus <= LottoConstants.INPUT_MIN_LOTTO || bonus > LottoConstants.INPUT_MAX_LOTTO) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER.getMessage());
            }
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMBER_BONUS.getMessage());
        }
    }

    private static List<Integer> parseIntToInput(String input) {
        try {
            return List.of(input.split(","))
                    .stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMBER_LOTTO.getMessage());
        }
    }
}
