package lotto.domain.gameManager;

import lotto.controller.Policy;
import lotto.domain.lottery.Lotteries;

public interface GameManager {

    Lotteries initLottery(Policy policy, int inputAmount);

    int calculateBuyCount(int inputAmount,int lotteryAmount);



}
