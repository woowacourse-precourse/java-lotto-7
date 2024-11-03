package lotto.domain;

import java.util.List;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto lotto) {
        this.bonusNumber = bonusNumber;
        validate(lotto);
    }

    //숫자가 1 ~ 45 사이인지
    //숫자가 당첨번호랑 겹치지 않는지
    private void validate(Lotto lotto) {
        rangeValidate();
        hasDuplicated(lotto);
    }

    private void rangeValidate() {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이여야 합니다.");
        }
    }

    private void hasDuplicated(Lotto lotto) {
        if (lotto.hasDuplicatedBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 될수 없습니다.");
        }
    }

    public boolean matching(List<Integer> userLotto) {
        if (userLotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
