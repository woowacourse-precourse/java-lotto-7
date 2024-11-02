package lotto.converter;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.CONVERT_STRING_TO_NUMBER;

public class StringToIntegerListConverter implements TypeConverter<String, List<Integer>> {

    private static final String BASE_DELIMITER = ",";

    @Override
    public List<Integer> convert(String target) {
        return Arrays.stream(target.split(BASE_DELIMITER))
                .map(String::strip)
                .map(this::toInteger)
                .toList();
    }

    private Integer toInteger(String target) {
        try {
            return Integer.valueOf(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_STRING_TO_NUMBER.message());
        }
    }
}
