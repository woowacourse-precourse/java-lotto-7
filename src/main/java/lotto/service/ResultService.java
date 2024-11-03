package lotto.service;

import java.util.ArrayList;
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
        loopResult(lottos);
    }

    public void loopResult(Lottos lottos) {
        HashMap<Integer, Integer> resultMap = result.getResultMap();

        for (Lotto lotto : lottos.getLottos()) {
            int winningCount = checkWinningNumbersCount(lotto.getNumber());
            resultMap.put(winningCount, resultMap.getOrDefault(resultMap.get(winningCount), 0) + 1);
        }
    }

    public int hasBonusNumber(List<Integer> lottoNumbers, int winningNumber) {
        if (lottoNumbers.contains(winning.getBonusNumber())) {
            return winningNumber + 10;
        }
        return winningNumber;
    }

    public boolean isFiveWinningNumber(int winningCount) {
        return winningCount == 5;
    }

    public int checkWinningNumbersCount(List<Integer> lottoNumbers) {
        List<Integer> lottoList = new ArrayList<>(lottoNumbers);
        return 6 - lottoList.size();
    }
}
