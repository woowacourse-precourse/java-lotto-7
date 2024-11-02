package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Integer totalBenefit;
    private final HashMap<WinningInfo, Integer> result = new HashMap<>();

    public LottoResult() {
        initResult();
    }

    private void initResult() {
        totalBenefit = 0;
        result.put(WinningInfo.FIRST_WINNER, 0);
        result.put(WinningInfo.SECOND_WINNER, 0);
        result.put(WinningInfo.THIRD_WINNER, 0);
        result.put(WinningInfo.FOURTH_WINNER, 0);
        result.put(WinningInfo.FIFTH_WINNER, 0);
        result.put(WinningInfo.NOT_MATCH, 0);
    }

    public void updateResult(WinningInfo winningInfo) {
        if(!winningInfo.equals(WinningInfo.UNDEFINED)) {
            result.put(winningInfo, result.get(winningInfo) + 1);
        }
    }

    public Double getProfitRate(Lottos lottos) {
        calculateTotalBenefit();
        double profit = (double) (totalBenefit / lottos.getLottoCount()) / 1000.0 * 100.0;
        return Math.round(profit * 10.0) / 10.0;
    }

    private void calculateTotalBenefit() {
        for (Map.Entry<WinningInfo, Integer> entry : result.entrySet()) {
            totalBenefit += entry.getKey().getWinningAmount() * entry.getValue();
        }
    }

    @Override
    public String toString() {
        return WinningInfo.FIFTH_WINNER.getInfo() + " - " + result.get(WinningInfo.FIFTH_WINNER) + "개" + "\n" +
                WinningInfo.FOURTH_WINNER.getInfo() + " - " + result.get(WinningInfo.FOURTH_WINNER) + "개" + "\n" +
                WinningInfo.THIRD_WINNER.getInfo() + " - " + result.get(WinningInfo.THIRD_WINNER) + "개" + "\n" +
                WinningInfo.SECOND_WINNER.getInfo() + " - " + result.get(WinningInfo.SECOND_WINNER) + "개" + "\n" +
                WinningInfo.FIRST_WINNER.getInfo() + " - " + result.get(WinningInfo.FIRST_WINNER) + "개" + "\n";
    }
}
