package lotto.converter;

import static lotto.message.ErrorMessage.CONVERT_STRING_TO_NUMBER;

public class StringToIntegerConverter implements TypeConverter<String, Integer> {

    @Override
    public Integer convert(String target) {
         try {
            return Integer.valueOf(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_STRING_TO_NUMBER.message());
        }
    }
}
