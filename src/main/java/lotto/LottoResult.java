package lotto;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {
    private Map<String, Integer> matchCount = new LinkedHashMap<>();
    double rateOfReturn;

    public void initMatchCount() {
        for (WinningCase winningCase : WinningCase.values()) {
            matchCount.put(winningCase.getMessage(), 0);
        }
    }

    public void calculateResults(int sameNumberCount, boolean bonusMatch) {
        updateMatchCount(sameNumberCount, bonusMatch);
    }

    private void updateMatchCount(int sameNumberCount, boolean bonusMatch) {
        if (sameNumberCount == 3) {
            incrementCount(WinningCase.FIFTH);
        }
        if (sameNumberCount == 4) {
            incrementCount(WinningCase.FOURTH);
        }
        if (sameNumberCount == 5) {
            isSameBonusNumber(bonusMatch);
        }
        if (sameNumberCount == 6) {
            incrementCount(WinningCase.FIRST);
        }
    }

    private void isSameBonusNumber(boolean bonusMatch) {
        if (bonusMatch) {
            incrementCount(WinningCase.SECOND);
        }
        if (!bonusMatch) {
            incrementCount(WinningCase.THIRD);
        }
    }

    private void incrementCount(WinningCase winningCase) {
        matchCount.put(winningCase.getMessage(), matchCount.getOrDefault(winningCase.getMessage(), 0) + 1);
    }

    public void printResult() {
        System.out.println("\n당첨 통계\n---");

        double totalPrize = 0;
        for (Entry<String, Integer> entry : matchCount.entrySet()) {
            String message = entry.getKey();
            int count = entry.getValue();
            System.out.println(message + count + "개");

            int prize = extractPrize(message) * count;
            totalPrize = totalPrize + prize;
        }
        printEarningRate(totalPrize);
    }

    private void printEarningRate(double totalPrize) {
        rateOfReturn = (totalPrize / PayForLotto.lottoPayout) * 100;
        rateOfReturn = (Math.round(rateOfReturn * 10) / 10.0);
        DecimalFormat rate = new DecimalFormat("###,##0.0");
        String earningRate = rate.format(rateOfReturn);

        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public int extractPrize(String message) {
        int startIndex = message.indexOf("(") + 1;
        int endIndex = message.indexOf("원");
        String prize = message.substring(startIndex, endIndex).replace(",", "");

        return Integer.parseInt(prize);
    }
}
