package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;

public class LottoGenerator {

    public List<Lotto> generateLottos(int amount) {
        int countOfGenerate = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countOfGenerate; count++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_LENGTH));
    }
}
