package buy;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class BuyingLotto {
    public List<Lotto> buyLotto(int money) {
        int lottoCnt = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }
}
