package lotto.model;

import lotto.common.constant.WinningInfo;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoMatcher {
    private final Map<WinningInfo, Integer> winningCount;
    private final WinningLotto winningLotto;
    private final Integer rateCalculateConstant = 100;
    private final Integer plusOne = 1;
    private final Integer defaultCount = 0;

    public LottoMatcher(WinningLotto winningLotto) {
        winningCount = new LinkedHashMap<WinningInfo, Integer>(WinningInfo.values().length);
        initializeWinningCount();
        this.winningLotto = winningLotto;
    }

    private void initializeWinningCount() {
        Stream.of(WinningInfo.values()).forEach(winningInfo ->
                winningCount.put(winningInfo, defaultCount)
        );
    }

    public void startMatch(Lottoes lottoes) {
        lottoes.getLottoes().forEach(lotto -> {
            WinningInfo prize = lotto.matchWithWinningLotto(winningLotto);
            setWinningCount(prize);
        });
    }

    private void setWinningCount(WinningInfo prize) {
        if (prize != null) {
            winningCount.put(prize, winningCount.getOrDefault(prize, defaultCount) + plusOne);
        }
    }

    public void printWinningResult() {
        winningCount.entrySet().forEach(entry -> {
            OutputView.printWinningResult(entry.getKey().toString(), winningCount.get(entry.getKey()));
        });
    }

    public void printRateOfWinningResult(PriceToBuyLotto priceToBuyLotto) {
        long earnings = winningCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPriceMoney() * entry.getValue())
                .sum();

        Double lottoEarningRate = (double) earnings / priceToBuyLotto.price() * rateCalculateConstant;
        String formattedLottoEarningRate = String.format("%.1f", lottoEarningRate);
        OutputView.printRateOfReturn(formattedLottoEarningRate);
    }
}
