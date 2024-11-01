package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.controller.Policy;

public class LottoGameManager implements GameManager{

    @Override
    public Lotteries initLottery(Policy policy, int totalBuyCount) {
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < totalBuyCount; i++) {
            List<Integer> pickLottoNumber = Randoms.pickUniqueNumbersInRange(
                    policy.getMinNumberLimit(), policy.getMaxNumberLimit(),policy.getWinningNumberCount());
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
