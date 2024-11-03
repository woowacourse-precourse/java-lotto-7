package lotto.domain.gameManager;

import java.util.List;
import lotto.controller.Policy;
import lotto.controller.TierPolicy;
import lotto.domain.lottery.Lotteries;
import lotto.domain.statistics.Statistics;

public interface GameManager {

    Lotteries initLottery(Policy policy, int inputAmount);

    int calculateBuyCount(int lotteryAmount, int inputAmount);

    List<Statistics> initStatistics(TierPolicy tierPolicy);

}
