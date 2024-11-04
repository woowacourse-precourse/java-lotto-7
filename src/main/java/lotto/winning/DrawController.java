package lotto.winning;

import lotto.donghang.WinningLotto;

import java.util.Map;

public class DrawController {

    private final DrawService drawService;

    public DrawController(DrawService drawService) {
        this.drawService = drawService;
    }

    public void checkResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = drawService.checkLotto(winningLotto);
        drawService.saveStatistics(result);
    }


}
