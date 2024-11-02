package lotto.validation;

import java.util.List;
import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class LottoNumbersValidator {
    public static void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateDuplicate(numbers);
    }


    private static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_LENGTH_INVALID);
        }
    }

    private static void validateLottoRange(List<Integer> numbers) {
        if (!isLottoRange(numbers)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_RANGE_INVALID);
        }
    }

    private static boolean isLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
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
