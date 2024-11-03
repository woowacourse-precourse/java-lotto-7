package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket() {
        this(new ArrayList<>());
    }

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> create(int lottoQuantity) {
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> result = new ArrayList<>(numbers);
            // numbers.sort(null);
            Collections.sort(result);
            lottos.add(new Lotto(result));
        }
        return lottos;
    }
}
