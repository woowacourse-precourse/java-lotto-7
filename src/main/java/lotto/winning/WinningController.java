package lotto.winning;

import java.util.Map;
import lotto.donghang.WinningLotto;

public class WinningController {

    private final WinningService winningService;

    public WinningController(WinningService winningService) {
        this.winningService = winningService;
    }

    public void checkResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = winningService.checkLotto(winningLotto);
        winningService.saveStatistics(result);
    }


}
