package lotto.model;

import lotto.common.constant.WinningInfo;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoMatcher {
    private final Map<WinningInfo, Integer> winningCount;
    private final WinningLotto winningLotto;

    public LottoMatcher(WinningLotto winningLotto) {
        winningCount = new LinkedHashMap<WinningInfo, Integer>(WinningInfo.values().length);
        initializeWinningCount();
        this.winningLotto = winningLotto;
    }

    private void initializeWinningCount(){
        Stream.of(WinningInfo.values()).forEach( winningInfo ->
                winningCount.put(winningInfo, 0)
        );
    }

    public void startMatch(Lottoes lottoes){
        lottoes.getLottoes().forEach(lotto -> {
            WinningInfo prize = lotto.matchWithWinningLotto(winningLotto);
            setWinningCount(prize);
        });
    }

    private void setWinningCount(WinningInfo prize){
        if(prize != null) {
            winningCount.put(prize, winningCount.getOrDefault(prize, 0) + 1);
        }
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
