package lotto;

public class LottoDrawingMachine {
    private final Lotto winningLotto;
    private int bonusNumber;

    public LottoDrawingMachine(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateRange(bonusNumber);
        validateBonusNumberUnique(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int input) {
        boolean isInvalid = input < Lotto.LOTTO_MINIMUM_NUMBER || input > Lotto.LOTTO_MAXIMUM_NUMBER;
        if (isInvalid) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateBonusNumberUnique(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 로또 숫자와 겹칠 수 없습니다.");
        }
    }
}
