package lotto.validators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusNumberValidator implements Validator {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String INCORRECT_TYPE = "소수점이 없는 양수를 입력해 주세요.";
    private static final String NOT_WITHIN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String CONTAINS_DUPLICATE = "로또 번호와 중복됩니다.";

    @Override
    public void validate(String input) {
        List<String> splitValues = List.of(input.split(":"));
        String bonusNumber = splitValues.get(0);
        String lottoNumbers = splitValues.get(1);
        checkInputType(bonusNumber);
        checkValueRange(bonusNumber);
        checkDuplicate(bonusNumber, lottoNumbers);
    }

    private void checkInputType(String input) {
        Pattern inputPattern = Pattern.compile(POSITIVE_WHOLE_INT_REGEX);
        Matcher matcher = inputPattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(INCORRECT_TYPE);
        }
    }

    private void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(NOT_WITHIN_RANGE);
        }
    }

    private void checkDuplicate(String input, String lottoNumbers) {
        List<String> numbers = List.of(lottoNumbers.split(SPLIT_DELIMITER));

        if (numbers.contains(input)) {
            throw new IllegalArgumentException(CONTAINS_DUPLICATE);
        }
    }
}
