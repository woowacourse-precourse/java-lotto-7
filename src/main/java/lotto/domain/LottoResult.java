package lotto.domain;

import static lotto.global.LottoScore.NO_PRIZE;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.global.LottoScore;

public class LottoResult {

    private static final String COMMA = ",";
    private static final String BLANK = "";
    private Map<LottoScore, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        for (LottoScore score : LottoScore.values()) {
            lottoResult.put(score, 0);
        }
    }

    public Map<LottoScore, Integer> integrateLottoScore(List<LottoScore> lottoScores) {
        for (LottoScore lottoScore : lottoScores) {
            if (lottoScore == NO_PRIZE) {
                continue;
            }
            lottoResult.put(lottoScore, lottoResult.get(lottoScore) + 1);
        }

        return lottoResult;
    }

    public void deleteNoPrize() {
        lottoResult.remove(NO_PRIZE);
    }

    public double calculateLottoProfit(int money) {
        double totalWinningMoney = 0;

        for (Map.Entry<LottoScore, Integer> entry : lottoResult.entrySet()) {
            LottoScore score = entry.getKey();
            int count = entry.getValue();
            totalWinningMoney += getWinningMoneyAsInt(score.getWinningMoney()) * count;
        }

        double profitRate = (totalWinningMoney / money) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    private int getWinningMoneyAsInt(String money) {
        return Integer.parseInt(money.replace(COMMA, BLANK));
    }
}