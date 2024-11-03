package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.Winning;
import lotto.view.ResultView;

public class ResultService {

    private final Lottos lottos;
    private static Winning winning;
    private final Result result = new Result();

    public ResultService(Lottos lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
    }

    public void run() {
        ResultView.displayLottoResult();
        checkWinningNumbersCount(lottos);
    }

    public int hasBonusNumber(List<Integer> lottoNumbers, int winningNumber) {
        if (lottoNumbers.contains(winning)) {
            return winningNumber + 10;
        }
        return winningNumber;
    }

    public boolean isFiveWinningNumber(int winningCount) {
        return winningCount == 5;
    }

    public void checkWinningNumbersCount(Lottos lottos) {
        HashMap<Integer, Integer> resultMap = result.getResultMap();
        for (Lotto lotto : lottos.getLottos()) {
            int winningCount = 6 - lotto.getSize();

            if (isFiveWinningNumber(winningCount)) {
                winningCount = hasBonusNumber(lotto.getNumber(), winningCount);
            }

            resultMap.put(winningCount, resultMap.getOrDefault(resultMap.get(winningCount), 0) + 1);
        }
    }
}
