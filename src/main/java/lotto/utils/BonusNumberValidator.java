package lotto.utils;

public class BonusNumberValidator {
    private static void validateIsNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void validateInRange(String number) {
        int num = Integer.parseInt(number);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }


}
