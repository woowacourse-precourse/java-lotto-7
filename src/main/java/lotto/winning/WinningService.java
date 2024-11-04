package lotto.winning;

import java.util.Map;
import lotto.donghang.WinningLotto;

public interface WinningService {

    Map<Rank, Integer> checkLotto(WinningLotto winningLotto);

    void saveStatistics(Map<Rank, Integer> result);
}
