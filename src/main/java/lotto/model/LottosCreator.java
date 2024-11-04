package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosCreator {
    public Lottos createLottos(Money money) {
        long canBuyQuantityOfLottos = getCanBuyQuantityOfLottos(money);
        List<List<Integer>> lottos = new ArrayList<>();
        for (int buy = 0; buy < canBuyQuantityOfLottos; buy++) {
            lottos.add(pickNumbersRange1To45());
        }
        return Lottos.init(lottos);
    }

    private static Long getCanBuyQuantityOfLottos(Money money) {
        return money.divideByUnit(1000L);
    }

    private List<Integer> pickNumbersRange1To45() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
