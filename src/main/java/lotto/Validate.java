package lotto;

public class Validate {
    public static void checkBuyAmountMatchLottoPrice(Integer amount) {
        if (amount % 1000 != 0) {
            ErrorException.runError("로또 구매 금액은 1000원으로 나누어 떨어지도록 해야합니다.");
        }
    }

    public static void checkBuyAmountPositive(Integer amount) {
        if (amount < 0) {
            ErrorException.runError("로또 구매 금액은 양수여야 합니다.");
        }
    }

    public static void checkBuyAmountValidate(Integer amount) {
        checkBuyAmountPositive(amount);
        checkBuyAmountMatchLottoPrice(amount);
    }
}
