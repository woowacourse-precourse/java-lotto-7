package lotto.domain.user;

import lotto.domain.Lotto;

public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLotto bonusLotto;

    public UserLotto(Lotto mainLotto, BonusLotto bonusLotto) {
        validateDuplicateBonusInMainLotto(mainLotto, bonusLotto);
        this.mainLotto = mainLotto;
        this.bonusLotto = bonusLotto;
    }

    private void validateDuplicateBonusInMainLotto(Lotto mainLotto, BonusLotto bonusLotto){
        if (bonusLotto.isDuplicateMainLotto(mainLotto)){
            throw new IllegalArgumentException("보너스 로또 번호가 6자리 로또 번호와 중복됩니다.");
        }

    }
}
