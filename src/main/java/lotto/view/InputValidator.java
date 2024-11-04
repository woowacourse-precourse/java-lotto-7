package lotto.view;

public class InputValidator {

    public int getValidPurchasedLottoAmount(String input) {
        try {
            int payment = Integer.parseInt(input);
            checkMinimumPayment(payment);
            return payment;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 가능합니다.");
        }
    }

    private void checkMinimumPayment(int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 구매 가능합니다.");
        }
    }
}
