package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.exception.Validator;

public class StringToLongConverter {
    private static final String DELIMITER = ",";
    private final List<Long> result;

    public StringToLongConverter(String input) {
        List<String> inputElements = Arrays.stream(input.split(DELIMITER)).toList();
        result = Validator.isNumeric(inputElements);
    }

    public List<Long> getResult() {
        return result;
    }
}
