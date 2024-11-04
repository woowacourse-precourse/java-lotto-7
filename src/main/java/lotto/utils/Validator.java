package lotto.utils;

import java.math.BigInteger;
import lotto.constant.ExceptionFactory;
import lotto.constant.ExceptionType;

public class Validator {


    //related to numeric string
    public static void validateNumericString(String numericString){

        try{
            Integer.parseInt(numericString);
        }catch (java.lang.Exception e){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.INVALID_NUMERIC_STRING);
        }
    }

    public static void validateIntRange(String numericString){

        BigInteger bigIntStage = new BigInteger(numericString);
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger minInt = BigInteger.valueOf(Integer.MIN_VALUE);
        if(bigIntStage.compareTo(maxInt)>0
                || bigIntStage.compareTo(minInt) < 0){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.OUT_OF_RANGE_INT);
        }
    }

    public static void validatePositiveNumber(int number){
        if(number <= 0){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.NON_POSITIVE_NUMBER);
        }
    }

    // related to string
    public static void validateBlankString(String string){
        if(string.isBlank()){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.EMPTY_STRING);
        }

    }
}
