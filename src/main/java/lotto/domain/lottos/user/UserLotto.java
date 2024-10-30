package lotto.domain.lottos.user;

import lotto.domain.lottos.Lotto;

/**
 * 로또를 대조하는 행위도 포함될까 역할에
 */
public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLotto bonusLotto;

    public UserLotto(Lotto mainLotto, BonusLotto bonusLotto) {
        validateDuplicateBonusInMainLotto(mainLotto, bonusLotto);
        this.mainLotto = mainLotto;
        this.bonusLotto = bonusLotto;
    }

    public Lotto getMainLotto() {
        return mainLotto;
    }

    public BonusLotto getBonusLotto() {
        return bonusLotto;
    }


    //fixme 만들기 하기 전에 하는게 좋은가
    //fixme get 해오는게 편할래나
    private void validateDuplicateBonusInMainLotto(Lotto mainLotto, BonusLotto bonusLotto){
        if (bonusLotto.isContainMainLotto(mainLotto)){
            throw new IllegalArgumentException("보너스 로또 번호가 6자리 로또 번호와 중복됩니다.");
        }

    }
}
