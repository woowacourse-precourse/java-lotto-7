package lotto.validator;

public class AmountValidator {
    // private 생성자: 클래스 인스턴스화 방지
    private AmountValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int isNumber(String input) {
        try {
            int amount = Integer.parseInt(input);
            checkAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    public static void checkAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 될 수 없습니다.");
        }
        if (amount == 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 0원입니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

}

