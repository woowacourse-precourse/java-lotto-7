package lotto.util;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoErrorMessage.DUPLICATE_INPUT_NUMBER;

public class InputJackpotNumbersValidator implements Validator {

    @Override
    public void validate(String input) {
        List<Integer> intList = StringParser.toIntList(input);
        validateUniqueNumbers(intList);
        Lotto lotto = new Lotto(intList);
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
