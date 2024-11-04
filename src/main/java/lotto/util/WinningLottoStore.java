package lotto.util;

import lotto.Lotto;

public class WinningLottoStore {

    private static final int LOTTO_PRICE = 1000;
    private static Lotto winningLotto;
    private static int bonusNumber;
    private static boolean isInitialized = false;

    private WinningLottoStore() {
    }

    public static Lotto getWinningLotto() {
        checkInitialization();
        return winningLotto;
    }

    public static int getBonusNumber() {
        checkInitialization();
        return bonusNumber;
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public static void setUpLottoStore(final Lotto lotto, final int bonusNum) {
        validateLotto(lotto);
        validateLottoNumber(bonusNum);
        winningLotto = lotto;
        bonusNumber = bonusNum;
        isInitialized = true;
    }

    private static void validateLotto(final Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException("[ERROR] 유효한 로또가 아닙니다.");
        }
    }

    private static void validateLottoNumber(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 유효한 로또 번호가 아닙니다.");
        }
    }

    private static void checkInitialization() {
        if (!isInitialized) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 등록되지 않았습니다.");
        }
    }
}
