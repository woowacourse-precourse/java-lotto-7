package lotto.utils;

import java.math.BigInteger;
import java.util.List;

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

   public static void validateDivisible(int source, int divider){
        int rest = 0;
        if(source % divider != rest){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.NON_DIVISIBLE);
        }
   }

   public static void validateSpecificRange(int number , int startRange,int endRange){

        if(number > endRange || number < startRange){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.OUT_OF_SPECIFIC_RANGE);
        }
   }

   public static void validateListSize(List<Integer> list, int size){
        if(list.size() != size){
            ExceptionFactory.throwIllegalArgumentException(ExceptionType.NOT_PROPER_SIZE);
        }
   }
}
