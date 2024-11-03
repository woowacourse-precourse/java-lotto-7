package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.ResultView;

public class ResultService {

    private final User user;
    private final Lottos lottos;
    private static Winning winning;
    private final Result result = new Result();

    public ResultService(User user, Lottos lottos, Winning winning) {
        this.user = user;
        this.lottos = lottos;
        this.winning = winning;
    }

    public void run() {
        ResultView.displayLottoResultTitle();
        loopResult(lottos);
        ResultView.displayLottoResultState(result.getResultMap());
        double profitability = calculateProfitability(result.getResultMap(), user.getMoney());
        ResultView.displayProfitability(profitability);
    }

    public double calculateProfitability(HashMap<Integer, Integer> resultMap, int money) {
        HashMap<Integer, Integer> calculateMap = resultMap;
        int winnerMoney = 0;

        winnerMoney += calculateMap.getOrDefault(3, 0) * 5000;
        winnerMoney += calculateMap.getOrDefault(4, 0) * 50000;
        winnerMoney += calculateMap.getOrDefault(5, 0) * 1500000;
        winnerMoney += calculateMap.getOrDefault(50, 0) * 30000000;
        winnerMoney += calculateMap.getOrDefault(6, 0) * 2000000000;

        return (winnerMoney - money) / (double) money * 100;
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
            return 50;
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
