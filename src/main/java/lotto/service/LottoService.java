package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class LottoService {
    private final List<Lotto> lotteries = new ArrayList<>();
    private final Map<CommonWinningStrategy, Integer> winningCounts;

    public LottoService(long numberOfLottery) {
        for (int i = 0; i < numberOfLottery; i++) {
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        winningCounts = new EnumMap<>(CommonWinningStrategy.class);

    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }


    public void getStatistics(List<Integer> winningLottery, int bonusLottery) {
        initWinningCounts();
        for (Lotto lotto : lotteries) {
            countWinning(lotto, winningLottery, bonusLottery);

        }
    }

    private void countWinning(Lotto lotto, List<Integer> winningLottery, int bonusLottery) {
        for (CommonWinningStrategy strategy : CommonWinningStrategy.values()) {
            List<Integer> checkMatchCount = new ArrayList<>(lotto.getNumbers());
            checkMatchCount.retainAll(winningLottery);

            if (checkMatchCount.size() == 5 && lotto.getNumbers().contains(bonusLottery)) {
                winningCounts.put(strategy, winningCounts.get(strategy) + 1);
                break;
            }

            if (checkMatchCount.size() == strategy.getMatch()) {
                winningCounts.put(strategy, winningCounts.get(strategy) + 1);
                break;
            }
        }
    }

    private void initWinningCounts() {
        for (CommonWinningStrategy strategy : CommonWinningStrategy.values()) {
            winningCounts.put(strategy, 0);
        }
    }

    public Map<CommonWinningStrategy, Integer> getWinningCounts() {
        return winningCounts;
    }
}
