package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToLottoConverter {
    private static final String DELIMITER = ",";
    private static final String ERROR_INVALID_DELIMITER = "구분자는 '" + DELIMITER + "'이어야 합니다.";
    private static final String ERROR_INVALID_NUMBER_FORMAT = "숫자로 변환할 수 없는 값이 포함되어 있습니다.";

    public static List<Integer> convert(String inputValue) {
        validateDelimiter(inputValue);
        return convertToIntegerList(inputValue);
    }

    private static void validateDelimiter(String inputValue) {
        if (!inputValue.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER);
        }
    }

    private static List<Integer> convertToIntegerList(String inputValue) {
        try {
            return Arrays.stream(inputValue.split(DELIMITER)).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT);
        }
    }

}
