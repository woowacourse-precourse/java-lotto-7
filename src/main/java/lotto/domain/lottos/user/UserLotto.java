package lotto.domain.lottos.user;

import static lotto.domain.InputErrorMessage.BONUS_LOTTO_DUPLICATE_SIX_LOTTO;

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
        StringBuilder printout = new StringBuilder();
        printout.append(mainLotto);
        printout.append(bonusLotto);
        return printout.toString();
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
                throw new IllegalArgumentException(BONUS_LOTTO_DUPLICATE_SIX_LOTTO.getMessage());
            }
            this.bonusLotto = new BonusLotto(bonusLotto);
        }

        public UserLotto build() {
            return new UserLotto(mainLotto, bonusLotto);
        }
    }

}
