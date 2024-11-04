package lotto.repository.winning;

import lotto.Lotto;

public class WinningRepositoryImpl implements WinningRepository {
    private Lotto winning;
    private int bonusNumber;

    @Override
    public void saveWinning(Lotto lotto) {
        winning = lotto;
    }

    @Override
    public Lotto getWinning() {
        return winning;
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
