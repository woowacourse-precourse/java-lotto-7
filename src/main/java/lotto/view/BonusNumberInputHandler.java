package lotto.view;

public class BonusNumberInputHandler {
    public static int validateBonusNumberIsInteger(String input) {
        if (input.contains(".")) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 정수여야 합니다.");
        }
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(("[ERROR] 보너스 숫자는 정수여야 합니다."));
        }
    }
}
