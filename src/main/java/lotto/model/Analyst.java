package lotto.model;

import java.text.DecimalFormat;
import java.util.List;

public class Analyst {
    private static final int FIFTH_WINNINGS_MONEY = 5000;
    private static final int FOURTH_WINNINGS_MONEY = 50000;
    private static final int THIRD_WINNINGS_MONEY = 1500000;
    private static final int SECOND_WINNINGS_MONEY = 30000000;
    private static final int FIRST_WINNINGS_MONEY = 2000000000;

    private int totalEarn;
    private String yield;
    private int[] winLottos = new int[6];
    private static final int[] winningsMoney = new int[]{
            FIFTH_WINNINGS_MONEY,
            FOURTH_WINNINGS_MONEY,
            THIRD_WINNINGS_MONEY,
            SECOND_WINNINGS_MONEY,
            FIRST_WINNINGS_MONEY
    };

    public Analyst(List<LottoResult> results, String inputMoney) {
        calculateWinLotto(results);
        calculateTotalEarn(results);
        calculateYield(inputMoney);
    }

    public int[] getWinLottos() {
        return winLottos;
    }

    public int[] winningsMoney() {
        return winningsMoney;
    }

    public String getYield() {
        return yield;
    }

    private void calculateWinLotto(List<LottoResult> results) {
        for (LottoResult result : results) {
            winLottos[Integer.parseInt(result.getWinningScore())]++;
        }
    }

    private void calculateTotalEarn(List<LottoResult> results) {
        totalEarn = results.stream().
                mapToInt(LottoResult::getWinningsMoney)
                .sum();
    }

    private void calculateYield(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        double earningsRate = ((double) totalEarn / money) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0#%");
        yield = decimalFormat.format(earningsRate / 100);
    }
}
