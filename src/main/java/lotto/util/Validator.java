package lotto.util;

public class Validator {

    public static void validateEmptyString(String userInput) {
        if(userInput==null || userInput.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
    }
    public static void validatePositiveNumber(int num) {
        if(num <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수가 아닙니다.");
        }
    }
}
