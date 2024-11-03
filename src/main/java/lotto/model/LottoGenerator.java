package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    public List<Lotto> generateLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(generate()));
        }
        return lottos;
    }
}
