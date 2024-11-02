package lotto.validator;

public class Validator {

    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
