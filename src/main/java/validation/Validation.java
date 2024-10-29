package validation;

import java.math.BigInteger;

public class Validation {
    private static final String BLANK_INPUT_ERROR = "[ERROR] 비어있는 문자열입니다.";
    private static final String INVALID_INPUT_ERROR = "[ERROR] 정상적인 입력이 아닙니다.";
    public static void blankInput(String str){
        if(str==null || str.isBlank()){
            throw new IllegalArgumentException(BLANK_INPUT_ERROR);
        }
    }
    public static void numberInput(String str){
        BigInteger num;
        try {
            num = new BigInteger(str);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        if(num.compareTo(BigInteger.ZERO) != 1)
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
    }
}

