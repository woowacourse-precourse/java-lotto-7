package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generate(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }
}
