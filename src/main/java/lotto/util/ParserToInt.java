package lotto.util;

import lotto.message.ErrorMessage;

public class ParserToInt {

    public static int parserToInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
