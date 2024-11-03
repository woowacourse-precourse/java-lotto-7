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

    public void start() {

    }

    public void getStatistics(List<Integer> winningLottery, int bonusLottery) {
        initWinningCounts();
        for (Lotto lotto : lotteries) {
            boolean checkBonus = isBonusMatch(lotto, bonusLottery);
            countWinning(lotto, winningLottery, checkBonus);

        }
    }

    private void countWinning(Lotto lotto, List<Integer> winningLottery, boolean checkBonus) {
        for (CommonWinningStrategy strategy : CommonWinningStrategy.values()) {
            if (checkBonus) {
                winningCounts.put(strategy, winningCounts.get(strategy) + 1);
                break;
            }

            List<Integer> checkMatchCount = lotto.getNumbers();
            checkMatchCount.retainAll(winningLottery);

            if (checkMatchCount.size() == strategy.getMatch()) {
                winningCounts.put(strategy, winningCounts.get(strategy) + 1);
                break;
            }
        }
    }

    private boolean isBonusMatch(Lotto lotto, int bonusLottery) {
        return lotto.getNumbers().contains(bonusLottery);
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
