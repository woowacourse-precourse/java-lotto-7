package lotto;

public class PaymentFormula {
    public void isLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }

    public void isPositive(String input) {
        if (Long.parseLong(input) <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해 주세요.");
        }
    }

    public void isDivisible(String input) {
        if (!(Long.parseLong(input) % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 입력만 가능합니다.");
        }
    }
}
