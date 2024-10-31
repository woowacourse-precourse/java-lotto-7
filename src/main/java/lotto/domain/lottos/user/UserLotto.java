package lotto.domain.lottos.user;

import lotto.domain.lottos.Lotto;

/**
 * 로또를 대조하는 행위도 포함될까 역할에
 */
public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLotto bonusLotto;

    public UserLotto(Lotto mainLotto, BonusLotto bonusLotto) {
        this.mainLotto = mainLotto;
        this.bonusLotto = bonusLotto;
    }


    public Lotto getMainLotto() {
        return mainLotto;
    }

    public BonusLotto getBonusLotto() {
        return bonusLotto;
    }

    public int getMainLottoMatchedCount(final Lotto randomLotto) {
        return mainLotto.getNumberOfMatches(randomLotto);
    }

    public boolean isContainBonusLotto(final Lotto randomLotto) {
        return bonusLotto.isContainMainLotto(randomLotto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mainLotto);
        sb.append(bonusLotto);
        return sb.toString();
    }


    /**
     * 사용 이유 : BonusLotto가 mainLotto에 중복되어있는지 확인하기위해서는 1. mainLotto을 먼저 입력받고 2. Bonus 객체를 생성시키기 전에
     */
    public static class Builder {
        private Lotto mainLotto;
        private BonusLotto bonusLotto;

        public Builder() {
        }

        public void mainLotto(Lotto mainLotto) {
            this.mainLotto = mainLotto;
        }

        public void bonusLotto(int bonusLotto) {
            if (mainLotto.isContainNumber(bonusLotto)) {
                throw new IllegalArgumentException("보너스 로또 번호가 6자리 로또 번호와 중복됩니다.");
            }
            this.bonusLotto = new BonusLotto(bonusLotto);
        }

        public UserLotto build() {
            return new UserLotto(mainLotto, bonusLotto);
        }
    }

}
