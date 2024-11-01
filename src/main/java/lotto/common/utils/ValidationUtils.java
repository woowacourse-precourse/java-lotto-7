package lotto.common.utils;

import java.util.List;

import static lotto.common.ExceptionConstants.*;

public class ValidationUtils {

    public static void validateInt(String str){
        if( !str.matches("\\d+") ) throw new IllegalArgumentException(NOT_INTEGER.getMessage());
    }

    public static void validateNULL(int number){
        if(number == 0) throw new IllegalArgumentException(IS_NULL.getMessage());
    }

    public static void validateNULL(String str){
        if(str.isEmpty() || str == null) throw new IllegalArgumentException(IS_NULL.getMessage());
    }

    public static void validateNumberRange(int number){
        if(number >= 45 ) throw new IllegalArgumentException(OVER_NUMBER_RANGE.getMessage());
    }

    public static void validateNumberSize(int arraySize){
        if(arraySize != 6 ) throw new IllegalArgumentException(OVER_NUMBER_SIZE.getMessage());
    }

    public static void validateUnit(int money){
        if ( (money % 1000) != 0) throw new IllegalArgumentException(NOT_BUY_UNIT.getMessage());
    }

    public static void validateDuplicateWinNumber(List<Integer> number){
        if(number.size() != number.stream().distinct().count() ) throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
    }

    public static void validateDuplicateBonusNumber(List<Integer> number, int bonusNumber){
        if (number.contains(bonusNumber)) { throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage()); }
    }


}
