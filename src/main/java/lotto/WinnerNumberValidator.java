package lotto;

import java.util.TreeSet;

public class WinnerNumberValidator {

    public static String isNotEmpty(String inputPurchaseAmount){
        if(inputPurchaseAmount == null || inputPurchaseAmount.isBlank()){
            throw new IllegalArgumentException("빈 값은 입력하실 수 없습니다.");
        }
        return inputPurchaseAmount;
    }

    public static int canParseToInt(String inputPurchaseAmount){
        try{
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다.");
        }
    }

    public static int isInRange(int inputPurchaseAmount){
        if(inputPurchaseAmount < 1 || inputPurchaseAmount > 45){
            throw new IllegalArgumentException("1 ~ 45 사이의 수를 입력하셔야 합니다.");
        }
        return inputPurchaseAmount;
    }

    public static void isSixDifferentNumbers(TreeSet<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("6개의 서로 다른 수를 입력하셔야 합니다.");
        }
    }

}
