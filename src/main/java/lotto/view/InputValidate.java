package lotto.view;

public class InputValidate {
    public static void validateBuyMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
    public static void validateWinningNumInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }
        if (!input.matches("\\d+(,\\d+)*")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표만 입력 가능합니다.");
        }
    }
    public static void validateBonusNum(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
