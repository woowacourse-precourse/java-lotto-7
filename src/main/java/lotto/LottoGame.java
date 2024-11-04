package lotto;

public class LottoGame {
    public LottoGame(String money) {
        validateMoney(money);
    }

    private void validateMoney(String money) {
        if (!isInteger(money)) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000 단위여야 합니다.");
        }
    }

    private boolean isInteger(String money) {
        try {
            Integer.parseInt(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
