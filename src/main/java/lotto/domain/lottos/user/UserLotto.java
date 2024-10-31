package lotto.domain.lottos.user;

import lotto.domain.lottos.Lotto;

public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLotto bonusLotto;

    public UserLotto(Lotto mainLotto, BonusLotto bonusLotto) {
        this.mainLotto = mainLotto;
        this.bonusLotto = bonusLotto;
    }

    public int getMainLottoMatchedCount(final Lotto randomLotto) {
        return mainLotto.getMatchedCount(randomLotto);
    }

    public boolean isContainBonusLotto(final Lotto randomLotto) {
        return bonusLotto.isContainedMainLotto(randomLotto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mainLotto);
        sb.append(bonusLotto);
        return sb.toString();
    }


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
