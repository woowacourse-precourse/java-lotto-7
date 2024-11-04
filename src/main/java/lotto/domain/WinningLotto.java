package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLottoNumbers);
        validateBonusNumber(bonusNumber);
        validateDuplicateWithBonus(winningLottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateWithBonus(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복되지 않아야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }

}
