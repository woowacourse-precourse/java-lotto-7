package lotto;

public class InputValidator {

    public void validateBuyLotto(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }
}
