package lotto.model;

public class WinLotto {
    private final Lotto winNumbers;
    private final int bonusNumber;

    public WinLotto(Lotto winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);

        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
