package lotto.utils;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;

public class Validator {


    //related to numeric string
    public static void validateNumericString(String numericString){

        try{
            Integer.parseInt(numericString);
        }catch (Exception e){
            ExceptionMessage.INVALID_NUMERIC_STRING.throwIllegalArgumentException();
        }
    }

    public static void validateIntRange(String numericString){

        BigInteger bigIntStage = new BigInteger(numericString);
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger minInt = BigInteger.valueOf(Integer.MIN_VALUE);
        if(bigIntStage.compareTo(maxInt)>0
                || bigIntStage.compareTo(minInt) < 0){
            ExceptionMessage.OUT_OF_RANGE_INT.throwIllegalArgumentException();
        }
    }

    public static void validatePositiveNumber(int number){
        if(number <= 0){
            ExceptionMessage.NON_POSITIVE_NUMBER.throwIllegalArgumentException();
        }
    }

    // related to string
    public static void validateBlankString(String string){
        if(string.isBlank()){
            ExceptionMessage.EMPTY_STRING.throwIllegalArgumentException();
        }

    }
}
