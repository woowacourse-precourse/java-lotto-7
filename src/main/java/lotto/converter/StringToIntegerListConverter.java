package lotto.converter;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.ERROR_CONVERT_STRING_TO_NUMBER;

public class StringToIntegerListConverter implements TypeConverter<String, List<Integer>> {

    private static final String BASE_DELIMITER = ",";

    @Override
    public List<Integer> convert(String value) {
        return Arrays.stream(value.split(BASE_DELIMITER))
                .map(String::strip)
                .map(this::toInteger)
                .toList();
    }

    private Integer toInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CONVERT_STRING_TO_NUMBER.message());
        }
    }
}
