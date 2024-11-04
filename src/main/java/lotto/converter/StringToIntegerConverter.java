package lotto.converter;

import static lotto.message.ErrorMessage.ERROR_CONVERT_STRING_TO_NUMBER;

public class StringToIntegerConverter implements TypeConverter<String, Integer> {

    @Override
    public Integer convert(String value) {
         try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CONVERT_STRING_TO_NUMBER.message());
        }
    }
}
