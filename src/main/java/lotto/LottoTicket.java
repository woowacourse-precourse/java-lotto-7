package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    private final List<Lotto> lottos;

    public LottoTicket() {
        this(new ArrayList<>());
    }

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> createLotto(int lottoQuantity) {
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
            List<Integer> result = new ArrayList<>(randomNumbers);
            Collections.sort(result);
            lottos.add(Lotto.with(result));
        }
        return lottos;
    }
}
