package lotto.view;

public class BonusNumberInputHandler {

    private BonusNumberInputHandler() {}

    public static void validateBonusNumber(String input) {
        int bonusNumber = validateBonusNumberIsInteger(input);
        validateBonusNumberRange(bonusNumber);
    }

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

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1에서 45 사이의 값이어야 합니다.");
        }
    }
}
