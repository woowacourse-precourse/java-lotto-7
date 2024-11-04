package lotto.winning;

import lotto.donghang.WinningLotto;

import java.util.Map;

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
