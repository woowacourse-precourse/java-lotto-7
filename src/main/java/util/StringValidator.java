package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringValidator {
    public static void checkNotNullOrEmpty(String text){
        if(text == null || text.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력한 문자열이 없습니다.");

    }

    public static void checkPositiveIntValue(String numString){
        if(!numString.matches("[1-9]\\d*"))
            throw new IllegalArgumentException("[ERROR] 양의 정수 값만 입력할 수 있습니다.");

    }

    public static void checkValidMoney(String moneyString){
        checkNotNullOrEmpty(moneyString);
        checkPositiveIntValue(moneyString);
        int money = Integer.parseInt(moneyString);
        if(money != 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어 떨어지지 않습니다.");
    }



    public static void checkValidNums(String numString){
        checkNotNullOrEmpty(numString);
        String[] nums = StringParser.parseString(numString, ",");
        if(nums.length != Constants.LOTTO_SET_SIZE)
            throw new IllegalArgumentException("[ERROR] 입력한 번호의 개수가 6개를 넘습니다");
        checkDuplicatedNums(nums);
        for(String num : nums){
            checkPositiveIntValue(num);
            checkValidLottoNum(Integer.parseInt(num));
        }
    }

    private static void checkDuplicatedNums(String[] nums){
        Set<String> numDuplicator = new HashSet<>(Arrays.asList(nums));
        if(nums.length != numDuplicator.size())
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
    }

    private static void checkValidLottoNum(int num){
        if(num < 1 || num > 45)
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 번호만 가능합니다.");
    }
}
