package lotto.validators;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoNumberValidator implements Validator {
    private static final String SPLIT_DELIMITER = ",";
    private static final int ARRAY_SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String INCORRECT_TYPE = "소수점이 없는 양수를 입력해 주세요.";
    private static final String NOT_WITHIN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INCORRECT_NUMBER_COUNT = "콤마(,)로 구분된 6개의 숫자를 입력해 주세요.";
    private static final String CONTAINS_DUPLICATE = "중복되는 번호가 있습니다.";

    @Override
    public void validate(String input) {
        List<String> numbers = List.of(input.split(SPLIT_DELIMITER));

        if (numbers.size() != ARRAY_SIZE) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNT);
        }
        checkDuplicate(input);

        for (String number : numbers) {
            checkInputType(number);
            checkValueRange(number);
        }
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

    private void checkDuplicate(String input) {
        try {
            Set.of(input.split(SPLIT_DELIMITER));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(CONTAINS_DUPLICATE);
        }
    }
}
