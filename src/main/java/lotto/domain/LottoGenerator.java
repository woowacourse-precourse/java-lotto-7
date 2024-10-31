package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    Lottos generateLottos(int quantity) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < quantity; ++count) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConfig.MINIMUM.getValue(), LottoConfig.MAXIMUM.getValue(), LottoConfig.SIZE.getValue());
        return new Lotto(numbers);
    }
}
