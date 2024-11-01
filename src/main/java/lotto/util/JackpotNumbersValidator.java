package lotto.util;

import lotto.constants.LottoErrorMessage;
import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoErrorMessage.*;

public class JackpotNumbersValidator implements Validator {

    @Override
    public void validate(String input) {
        List<Integer> intList = validateNumber(input);

        validateUniqueNumbers(intList);
        Lotto lotto = new Lotto(intList);
    }

    private static List<Integer> validateNumber(String input) {
        try {
            return StringParser.toIntList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateUniqueNumbers(List<Integer> intList) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (Integer i : intList) {
            if (!uniqueSet.add(i)) {
                throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER.getMessage());
            }
        }
    }
}
