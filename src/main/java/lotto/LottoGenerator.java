package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static lotto.LottoConstants.*;

public class LottoGenerator {
    public List<Lotto> generate(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }
}
