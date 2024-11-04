package lotto.common.utils;

import lotto.common.ConstantData;

import java.util.List;

import static lotto.common.ExceptionConstants.*;

public class ValidationUtils {

    private static final int NUMBER_MIN_RANGE = 1;
    private static final int NUMBER_MAX_RANGE = 45;
    private static final String DIGIT_PATTERN_STRING = "\\d+";

    public static void validateInt(String str){
        if( !str.matches(DIGIT_PATTERN_STRING) ) throw new IllegalArgumentException(NOT_INTEGER.getMessage());
    }

    public static void validateNotUsedNumber(int number){
        if(number <= 0) throw new IllegalArgumentException(IS_NULL.getMessage());
    }

    public static void validateNull(String str){
        if(str == null || str.isEmpty() ) throw new IllegalArgumentException(IS_NULL.getMessage());
    }

    public static void validateNumberRange(int number){
        if(number < NUMBER_MIN_RANGE || number >= NUMBER_MAX_RANGE ) throw new IllegalArgumentException(OVER_NUMBER_RANGE.getMessage());
    }

    public static void validateNumberSize(int arraySize){
        if(arraySize != ConstantData.NUMBER_COUNT ) throw new IllegalArgumentException(OVER_NUMBER_SIZE.getMessage());
    }

    public static void validateUnit(int money){
        if ( (money % ConstantData.MONEY_UNIT) != 0) throw new IllegalArgumentException(NOT_BUY_UNIT.getMessage());
    }

    public static void validateDuplicateWinNumber(List<Integer> number){
        if(number.size() != number.stream().distinct().count() ) throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
    }

    public static void validateDuplicateBonusNumber(List<Integer> number, int bonusNumber){
        if (number.contains(bonusNumber)) { throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage()); }
    }


}
