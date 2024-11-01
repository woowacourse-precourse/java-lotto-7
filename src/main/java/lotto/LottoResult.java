package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Integer totalBenefit;
    private final Lotto winningNumber;
    private final Integer bonusNumber;
    private final HashMap<WinningInfo, Integer> result = new HashMap<>();

    public LottoResult(Lotto winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        initResult();
    }

    public void initResult() {
        this.totalBenefit = 0;
        result.put(WinningInfo.FIRST_WINNER, 0);
        result.put(WinningInfo.SECOND_WINNER, 0);
        result.put(WinningInfo.THIRD_WINNER, 0);
        result.put(WinningInfo.FOURTH_WINNER, 0);
        result.put(WinningInfo.FIFTH_WINNER, 0);
    }

    public void calculate(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer count = lotto.howManyMatches(winningNumber);
            if (count.equals(6)) {
                result.put(WinningInfo.FIRST_WINNER, result.get(WinningInfo.FIRST_WINNER) + 1);
            }
            if (count.equals(5) && lotto.contains(bonusNumber)) {
                result.put(WinningInfo.SECOND_WINNER, result.get(WinningInfo.SECOND_WINNER) + 1);
            }
            if (count.equals(5) && !lotto.contains(bonusNumber)) {
                result.put(WinningInfo.THIRD_WINNER, result.get(WinningInfo.THIRD_WINNER) + 1);
            }
            if (count.equals(4)) {
                result.put(WinningInfo.FOURTH_WINNER, result.get(WinningInfo.FOURTH_WINNER) + 1);
            }
            if (count.equals(3)) {
                result.put(WinningInfo.FIFTH_WINNER, result.get(WinningInfo.FIFTH_WINNER) + 1);
            }
        }
    }

    public void calculateTotalBenefit() {
        for (Map.Entry<WinningInfo, Integer> entry : result.entrySet()) {
            totalBenefit += entry.getKey().getWinningAmount() * entry.getValue();
        }
    }

    public Double getProfit(Lottos lottos) {
        return (double) (totalBenefit / lottos.getLottoCount()) * 100.0;
    }

    @Override
    public String toString() {
        return WinningInfo.FIFTH_WINNER.getInfo() + "-" + result.get(WinningInfo.FIFTH_WINNER) + "개" + "\n" +
                WinningInfo.FOURTH_WINNER.getInfo() + "-" + result.get(WinningInfo.FOURTH_WINNER) + "개" + "\n" +
                WinningInfo.THIRD_WINNER.getInfo() + "-" + result.get(WinningInfo.THIRD_WINNER) + "개" + "\n" +
                WinningInfo.SECOND_WINNER.getInfo() + "-" + result.get(WinningInfo.SECOND_WINNER) + "개" + "\n" +
                WinningInfo.FIRST_WINNER.getInfo() + "-" + result.get(WinningInfo.FIRST_WINNER) + "개" + "\n";
    }
}
