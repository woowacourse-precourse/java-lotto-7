package lotto.validator;


public class BonusNumberValidator {
    public static int getValidated(String input) {
        try {
            int number = Integer.parseInt(input);
            validateRange(number); // 범위 검증 호출
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다.");
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
        }
    }
}