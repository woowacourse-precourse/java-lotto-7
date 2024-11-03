package lotto.converter;

import lotto.util.ErrorMessage;

public class StringToIntConverter {

    public int convert(String rawNum) {
        try {
            return Integer.parseInt(rawNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMsg());
        }
    }
}
