package lotto.repository.winning;

import lotto.Lotto;

public interface WinningRepository {
    void saveWinning(Lotto lotto);

    Lotto getWinning();

    void saveBonusNumber(int bonusNumber);
}
