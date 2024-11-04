package lotto.domain.gameManager;

import java.util.List;
import lotto.controller.Policy;
import lotto.controller.TierPolicy;
import lotto.controller.dto.LotteryStatisticsResultDTO;
import lotto.domain.lottery.Lotteries;
import lotto.domain.statistics.LotteryStatisticsHistory;
import lotto.domain.statistics.Statistics;

public interface GameManager {

    Lotteries generateLottery(Policy policy, int inputAmount);

    int calculateBuyCount(int lotteryAmount, int inputAmount);

    List<Statistics> initStatistics();

    LotteryStatisticsResultDTO checkWinningLottery(int inputAmount,Lotteries boughtLotteries, List<Integer> winningNumbers,
                                                   int bonusNumber, LotteryStatisticsHistory lotteryStatisticsHistory);

}
