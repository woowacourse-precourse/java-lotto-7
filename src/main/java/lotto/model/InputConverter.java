package lotto.model;

import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputConverter {

    private static final String SPLITTER = ",";

    public static Set<Integer> convertWinNumbers(String winNumbers) {
        String[] splitNumbers = winNumbers.split(SPLITTER);
        List<Integer> numbers = Arrays.stream(splitNumbers).map(Integer::valueOf).toList();
        LottoValidator.validateLotto(numbers);
        return new HashSet<>(numbers);
    }

    public static int convertBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        LottoValidator.validateNumberRange(bonusNumber);
        return bonusNumber;
    }
}
