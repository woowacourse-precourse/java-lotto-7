package lotto.service;

import java.util.HashMap;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.view.ResultView;

public class ResultService {

    private final Lottos lottos;
    private final Result result = new Result();

    public ResultService(Lottos lottos) {
        this.lottos = lottos;
    }

    public void run() {
        ResultView.displayLottoResult();
        checkWinningNumbersCount(lottos);
    }

    public boolean isFiveWinningNumber(int winningCount) {
        return winningCount == 5;
    }

    public void checkWinningNumbersCount(Lottos lottos) {
        HashMap<Integer, Integer> resultMap = result.getResultMap();
        for (Lotto lotto : lottos.getLottos()) {
            int winningCount = 6 - lotto.getSize();

            isFiveWinningNumber(winningCount);

            resultMap.put(winningCount, resultMap.getOrDefault(resultMap.get(winningCount), 0) + 1);
        }
    }
}
