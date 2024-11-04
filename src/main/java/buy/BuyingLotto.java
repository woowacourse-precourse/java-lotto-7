package buy;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import print.InputRequest;

public class BuyingLotto {
    InputRequest inputRequest = new InputRequest();

    public List<List<Integer>> buyLotto(int money) {
        int lottoCnt = money / 1000;

        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(pickUniqueNumbersInRange(1, 45, 6));
        }

        return lottos;
    }
}
