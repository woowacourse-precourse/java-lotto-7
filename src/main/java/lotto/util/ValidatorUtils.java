package lotto.util;

public class ValidatorUtils {

    public static String isNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력하실 수 없습니다.");
        }
        return input;
    }

    public static int canParseToInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력하셔야 합니다.");
        }
    }

    public static int isInRange(int input){
        if(input < 1 || input > 45){
            throw new IllegalArgumentException("1 ~ 45 사이의 수를 입력하셔야 합니다.");
        }
        return input;
    }
}
