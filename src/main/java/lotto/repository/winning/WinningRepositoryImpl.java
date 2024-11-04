package lotto.repository.winning;

import lotto.Lotto;

public class WinningRepositoryImpl implements WinningRepository{
    private Lotto winning;

    @Override
    public void saveWinning(Lotto lotto) {
        winning = lotto;
    }

    @Override
    public Lotto getWinning() {
        return winning;
    }
}
