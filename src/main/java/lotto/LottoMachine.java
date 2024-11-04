package lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoMachine {

    public List<Lotto> purchaseLottos(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(generateLotto());
        }
        return tickets;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
