package lotto;

public class LottoGame {
    private static final int LOTTO_COST = 1000;

    private final MyLotto myLotto;

    public LottoGame(String money) {
        validateMoney(money);

        int lottoCount = Integer.parseInt(money) / LOTTO_COST;
        this.myLotto = new MyLotto(lottoCount);
    }

    private void validateMoney(String money) {
        if (!isInteger(money)) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(money) % LOTTO_COST != 0) {
            throw new IllegalArgumentException("구입금액은 " + LOTTO_COST + " 단위여야 합니다.");
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
