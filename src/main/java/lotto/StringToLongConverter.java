package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.exception.Validator;

public class StringToLongConverter {
    private static final String DELIMITER = ",";
    private final List<Integer> result;

    public StringToLongConverter(String input) {
        List<String> inputElements = Arrays.stream(input.split(DELIMITER)).toList();
        result = Validator.isNumeric(inputElements);
    }

    public List<Integer> getResult() {
        return result;
    }
}
