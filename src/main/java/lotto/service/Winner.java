package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.Winnings;

public class Winner {

    private final List<Integer> lottoNumbers; // 당첨 번호
    private final int bonusNumber; // 보너스 번호
    private final Map<Integer, List<Integer>> getLottoNumbers; // 사용자 로또 번호
    private final Map<Winnings, Integer> winningsStats; // Enum을 사용한 통계

    private final double calculateReturnRate; // 총 계산 금액

    public Winner(List<Integer> lottoNumbers, int bonusNumber, Map<Integer, List<Integer>> getLottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        this.getLottoNumbers = getLottoNumbers;
        this.winningsStats = new HashMap<>();

        calculateWinnings();
        this.calculateReturnRate = calculateWinningsRate();
    }

    private void calculateWinnings() {
        for (List<Integer> userNumbers : getLottoNumbers.values()) {
            int matchCount = getMatchCount(userNumbers);
            boolean bonusMatch = userNumbers.contains(bonusNumber);
            updateWinningsStats(matchCount, bonusMatch);
        }
    }

    private int getMatchCount(List<Integer> userNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void updateWinningsStats(int matchCount, boolean bonusMatch) {
        Winnings winnings = Winnings.getByMatchCount(matchCount, bonusMatch);
        if (winnings != null) { // winnings가 null이 아닐 경우에만 처리
            winningsStats.put(winnings, winningsStats.getOrDefault(winnings, 0) + 1);
        }
    }

    public Map<Winnings, Integer> getWinningsStats() {
        return winningsStats;
    }

    private double calculateWinningsRate(){
        int totalPurchaseAmount = getLottoNumbers.size() * 1000;
        int totalWinnings = 0;

        totalWinnings = getTotalWinnings(totalWinnings);

        if (totalPurchaseAmount == 0) {
            return 0;
        }

        double rate = (double) totalWinnings * 100 / totalPurchaseAmount; // 소수점 계산을 위해 double로 형 변환

        // 소수점 둘째 자리에서 반올림
        return Math.round(rate * 100.0) / 100.0; // 소수점 둘째 자리로 반올림

    }

    private int getTotalWinnings(int totalWinnings) {
        for (Map.Entry<Winnings, Integer> entry : winningsStats.entrySet()) {
            Winnings winnings = entry.getKey();
            int count = entry.getValue();

            // 당첨 통계에 따른 금액을 총 당첨 금액에 추가
            totalWinnings += winnings.getPrize() * count; // 각 당첨 등급의 금액 * 해당 등급의 갯수
        }
        return totalWinnings;
    }

    public double getCalculateReturnRate() {
        return calculateReturnRate;
    }



}
