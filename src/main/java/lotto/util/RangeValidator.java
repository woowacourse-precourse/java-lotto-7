package lotto.util;

public class RangeValidator {

    public static void numberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR} 1~45의 숫자를 입력하시오");
        }
    }

}



