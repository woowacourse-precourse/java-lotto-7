package lotto.service.winning;

import java.util.List;

public interface WinningService {
    void saveWinning(List<Integer> numbers);

    void saveBonusNumber(int bonusNumber);
}
