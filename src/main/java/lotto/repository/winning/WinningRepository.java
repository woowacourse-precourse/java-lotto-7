package lotto.repository.winning;

import java.util.List;
import lotto.Lotto;

public interface WinningRepository {
    void saveWinning(Lotto lotto);

    Lotto getWinning();

    void saveBonusNumber(int bonusNumber);

    List<Integer> getWinningNumbers();

    int getBonusNumber();
}
