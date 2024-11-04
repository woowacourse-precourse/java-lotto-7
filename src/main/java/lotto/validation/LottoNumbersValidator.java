package lotto.validation;

import static lotto.util.LottoConstants.LOTTO_LENGTH;
import static lotto.util.LottoConstants.ZERO_THRESHOLD;

import java.util.Arrays;
import java.util.List;
import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class LottoNumbersValidator {
    private final static String COMMA = ",";

    public static void validateLottoNumberFormat(String input) {
        CommonLottoNumberValidator.validateNotNullOrEmpty(input);
        validateHasComma(input);
        validateCommaSeparator(input);
        validateIsNumber(input);
    }

    public static void validateLottoNumbers(List<Integer> input) {
        validateLottoLength(input);
        validateDuplicate(input);
        for (Integer number : input) {
            CommonLottoNumberValidator.validateLottoRange(number);
        }
    }

    private static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getValue()) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_LENGTH_INVALID);
        }
    }

    private static void validateHasComma(String input) {
        if (!input.contains(COMMA)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateCommaSeparator(String input) {
        String[] inputs = input.split(COMMA);
        long count = Arrays.stream(inputs)
                .map(String::trim)
                .filter(String::isEmpty).count();
        if (count > ZERO_THRESHOLD.getValue()) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateIsNumber(String input) {
        Arrays.stream(input.split(COMMA))
                .forEach(number -> {
                    try {
                        Integer.parseInt(number);
                    } catch (NumberFormatException e) {
                        throw new InvalidInputException(InputErrorMessage.INTEGER_REQUIRED);
                    }
                });
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (!containsDuplicates(numbers)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_CANNOT_DUPLICATE);
        }
    }

    private static boolean containsDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

}
