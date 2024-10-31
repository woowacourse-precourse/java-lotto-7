package lotto.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberUtility {

    private static final String CANNOT_USE_INSTANCE_ERROR_MSG = "해당 유틸리티 클래스를 인스턴스화 할 수 없습니다.";
    private static final String IS_NOT_NUMBER_ERROR_MSG = "숫자가 아닌 입력입니다.";

    public NumberUtility(){
        throw new IllegalStateException(CANNOT_USE_INSTANCE_ERROR_MSG);
    }

    private static final String IS_NUMBER_REGEX = "^[0-9]+$";

    public static boolean isNumber(String s){
        return s.matches(IS_NUMBER_REGEX);
    }

    public static int getNumber(String s){
        if(!isNumber(s)){
            throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MSG);
        }
        return Integer.parseInt(s);
    }

    public static boolean isNumbers(List<String> stringList) {
        for(String s : stringList){
            if(!isNumber(s)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPositive(int num) {
        if(num >= 1) return true;
        return false;
    }

    public static boolean isDuplicateNumberExists(List<Integer> numbers) {
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for(Integer num : numbers){
            if(duplicateCheckSet.contains(num)) {
                return true;
            }
            duplicateCheckSet.add(num);
        }
        return false;
    }
}
