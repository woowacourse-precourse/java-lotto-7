package lotto.util;

import lotto.message.ErrorMessage;

public class ParserToInt {

    /**
     * 문자열을 정수형으로 변환 해주는 메서드
     * @param number 문자열
     * @return
     */
    public static int parserToInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
