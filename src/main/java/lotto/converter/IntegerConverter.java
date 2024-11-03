package lotto.converter;

import lotto.constant.ErrorConstant;

public class IntegerConverter {

    public static int getInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorConstant.ERROR.getContent() + " 올바른 숫자가 아닙니다.");
        }
    }
}
