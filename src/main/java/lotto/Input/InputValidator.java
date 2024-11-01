package lotto.Input;

public class InputValidator {
    public int validatePurchaseFormat(String input) {
        try {
            Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return 0;
    }
}
