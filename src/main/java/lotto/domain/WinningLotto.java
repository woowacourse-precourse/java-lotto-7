package lotto.domain;

import lotto.util.LottoNumberValidator;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int number) {
        LottoNumberValidator.validateNumberInRange(number);
    }

    public int countMatchNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
    }

    public boolean matchBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }
}
