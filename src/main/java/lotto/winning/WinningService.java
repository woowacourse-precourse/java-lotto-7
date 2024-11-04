package lotto.winning;


import lotto.donghang.WinningLotto;

import java.util.Map;

public interface WinningService {

    Map<Rank, Integer> checkLotto(WinningLotto winningLotto);

    void saveStatistics(Map<Rank, Integer> result);
}
