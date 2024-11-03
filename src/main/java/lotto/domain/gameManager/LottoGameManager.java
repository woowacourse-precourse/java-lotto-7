package lotto.domain.gameManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.controller.Policy;
import lotto.domain.lottery.Lotteries;
import lotto.domain.lottery.Lottery;
import lotto.domain.lottery.Lotto;

public class LottoGameManager implements GameManager {

    @Override
    public Lotteries initLottery(Policy policy, int inputAmount) {
        List<Lottery> lotteries = new ArrayList<>();
        int calculateBuyCount = calculateBuyCount(policy.getAmountPolicy(), inputAmount);
        for (int i = 0; i < calculateBuyCount; i++) {
            List<Integer> pickLottoNumber = Randoms.pickUniqueNumbersInRange(
                    policy.getMinNumberLimit(), policy.getMaxNumberLimit(),policy.getWinningNumberCount());
            Collections.sort(pickLottoNumber);
            Lotto lotto = new Lotto(pickLottoNumber);
            lotteries.add(lotto);
        }
        return Lotteries.newInstance(lotteries);
    }

    @Override
    public int calculateBuyCount(int lotteryAmount, int inputAmount) {
        return inputAmount/lotteryAmount;
    }

}
