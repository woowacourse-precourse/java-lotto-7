package lotto.converter;

import static lotto.message.ErrorMessage.ERROR_CONVERT_STRING_TO_NUMBER;

public class StringToLongConverter implements TypeConverter<String, Long> {

    @Override
    public Long convert(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CONVERT_STRING_TO_NUMBER.message());
        }
    }
}
