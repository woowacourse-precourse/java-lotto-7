package lotto;

import java.util.List;

public class CorrectLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public CorrectLotto(Lotto lotto, int bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    void validateDuplicate(Lotto lotto, int bonusNumber) {
        if(lotto.numbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 정답 번호는 중복될 수 없습니다.");
        }
    }
}
