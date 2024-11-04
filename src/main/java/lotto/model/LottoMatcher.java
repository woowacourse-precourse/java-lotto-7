package lotto.model;

import lotto.common.constant.WinningInfo;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LottoMatcher {
    private final Map<WinningInfo, Integer> winningCount;
    private final WinningLotto winningLotto;

    public LottoMatcher(WinningLotto winningLotto) {
        winningCount = new HashMap<WinningInfo, Integer>(WinningInfo.values().length);
        this.winningLotto = winningLotto;
    }

    public void startMatch(Lottoes lottoes){
        lottoes.getLottoes().forEach(lotto -> {
            WinningInfo prize = lotto.matchWithWinningLotto(winningLotto);
            winningCount.put(prize, winningCount.get(prize) + 1);
        });
    }

    public void printWinningResult(){
        winningCount.entrySet().forEach(entry -> {
            OutputView.printWinningResult(entry.getKey().toString(), winningCount.get(entry.getKey()));
        });
    }

    public void printRateOfWinningResult(PriceToBuyLotto priceToBuyLotto){
        long earnings = winningCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPriceMoney() * entry.getValue())
                .sum();

        Double lottoEarningRate = (double)earnings/priceToBuyLotto.price() * 100;
        String formattedLottoEarningRate = String.format("%.2f", lottoEarningRate);
        OutputView.printRateOfReturn(formattedLottoEarningRate);
    }
}
