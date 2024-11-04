package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningStatistic;

import java.util.*;


public class LottoResultService {
    public static final Map<Integer, Integer> PRIZE_MAP;

    static {
        Map<Integer, Integer> tempMap = new HashMap<>();
        tempMap.put(3, 5000);
        tempMap.put(4, 50000);
        tempMap.put(5, 1500000);
        tempMap.put(6, 2000000000);

        PRIZE_MAP = Collections.unmodifiableMap(tempMap);
    }

    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;



    public LottoResultService(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto purchasedLotto, Lotto winningLotto) {
        int count = 0;
        for (int winningNumber : winningLotto.getNumbers()) {
            count += getMatchCount(purchasedLotto, winningNumber);
        }
        return count;
    }

    public int getMatchCount(Lotto lotto, int winningNumber) {
        if (lotto.getNumbers().contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean matchBonus(Lotto purchasedLotto, int bonusNumber) {
        if (purchasedLotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public List<WinningStatistic> generateWinningStatistics() {
        List<WinningStatistic> statistics = new ArrayList<>();
        for(int key: PRIZE_MAP.keySet()) {
            statistics.add(new WinningStatistic(key, PRIZE_MAP.get(key)));
            if(key == 5) { // 보너스일치인 경우는 따로 처리
                statistics.add(new WinningStatistic(key, 30000000));
            }
        }
        return statistics;
    }

    public static long calculateTotalEarnings(List<WinningStatistic> statistics) {
        long totalEarnings = 0;
        for (WinningStatistic winningStatistic : statistics) {
            totalEarnings += winningStatistic.calculateEarnings();
        }
        return totalEarnings;
    }

}
