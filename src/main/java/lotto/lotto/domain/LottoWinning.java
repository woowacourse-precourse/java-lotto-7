package lotto.lotto.domain;

public class LottoWinning {

    private final Lotto lotto;
    private final int bonusNumber;

    private LottoWinning(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning of(Lotto lotto, int bonusNumber) {
        validateLottoWinning(lotto, bonusNumber);
        return new LottoWinning(lotto, bonusNumber);
    }

    private static void validateLottoWinning(Lotto lotto, int bonusNumber) {
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 부터 45까지의 정수이여야 합니다");
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호에 포함될 수 없습니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
