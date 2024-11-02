package lotto.converter;

import static lotto.message.ErrorMessage.CONVERT_STRING_TO_NUMBER;

public class StringToLongConverter implements TypeConverter<String, Long> {

    @Override
    public Long convert(String target) {
        try {
            return Long.valueOf(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_STRING_TO_NUMBER.message());
        }
    }
}
