package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {

    public List<List<Integer>> lotteryTickets = new ArrayList<>();

    public void publishLotto(int count) {
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}
