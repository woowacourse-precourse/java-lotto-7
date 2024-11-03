package lotto.model;

import java.util.List;

public class PrizeLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public PrizeLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public int countWinningLottoMatched(Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static PrizeLotto from(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(lottoNumbers);
        return new PrizeLotto(winningLotto, bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("로또 숫자의 범위는 1부터 45입니다.");
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 숫자가 중복될 수 없습니다.");
        }
    }
}
