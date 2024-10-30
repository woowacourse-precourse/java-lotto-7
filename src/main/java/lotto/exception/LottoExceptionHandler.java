package lotto.exception;

public class LottoExceptionHandler {
    public static void validatePurchase(int lottoAmount) {
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (lottoAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1원 이상의 양수로 입력해야 합니다.");
        }
        if (lottoAmount > 100000000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 큽니다. 다시 입력해 주세요.");

        }
    }
}
