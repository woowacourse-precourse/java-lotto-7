package lotto.domain;

import lotto.controller.Policy;

public interface GameManager {

    Lotteries initLottery(Policy policy,int inputAmount);

    int calculateBuyCount(int inputAmount,int lotteryAmount);



}
