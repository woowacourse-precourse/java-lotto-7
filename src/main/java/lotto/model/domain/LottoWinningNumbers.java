package lotto.model.domain;

import java.util.List;

public class LottoWinningNumbers extends Lotto{

    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(List<Integer> numbers, BonusNumber bonusNumber) {
        super(numbers);
        bonusNumberDuplicateValidator(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberDuplicateValidator(List<Integer> numbers, BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public BonusNumber getWinningBonusNumber() {
        return bonusNumber;
    }
}