package lotto;

import java.util.*;

public class Results {

    private final List<Lotto> lottoList;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;
    private final int givenAmount;
    private double rateOfReturn;
    private Map<Prize, Integer> statistics;

    public Results(int givenAmount, List<Lotto> lottoList, List<Integer> numbers, int bonusNumber) {
        this.lottoList = lottoList;
        winningNumbers = new HashSet<>(numbers);
        this.bonusNumber = bonusNumber;
        this.givenAmount = givenAmount;
        initializeMap();
    }

    private void initializeMap() {
        statistics = new HashMap<>();
        for (Prize prize: Prize.values()) {
            if (prize != Prize.NONE) {
                statistics.put(prize, 0);
            }
        }
    }

    public void printResults() {
        getResults();
        System.out.println("당첨 통계");
        System.out.println("---");

        // Prize를 5등에서 부터 출력하기
        Prize[] prizes = Prize.values();
        // PRIZE.NONE 은 제외
        for (int i = prizes.length - 2; i >= 0; i--) {
            System.out.println(prizes[i].toString(statistics.get(prizes[i])));
        }
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }

    private void getResults() {
        calculateStats();
        calculateRateOfReturn();
    }

    private void calculateStats() {
        for (Lotto lotto: lottoList) {
            int winCount = matchNumbers(lotto);
            boolean bonusMatch = matchBonus(lotto);
            Prize prize = Prize.getPrizeByMatch(winCount, bonusMatch);
            if (prize != Prize.NONE) {
                statistics.put(prize, statistics.get(prize) + 1);
            }
        }
    }

    private void calculateRateOfReturn() {
        long sum = 0;
        for (Prize prize : statistics.keySet()) {
            int count = statistics.get(prize);
            sum += prize.calculateTotalPrize(count);
        }
        rateOfReturn = (double) sum / givenAmount * 100;
    }

    private int matchNumbers(Lotto lotto) {
        int count = 0;

        for (int number: lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean matchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
