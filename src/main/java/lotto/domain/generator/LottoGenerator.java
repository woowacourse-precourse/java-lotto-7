package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public List<Lotto> generateLottoGroup(int ticket) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < ticket) {
            lottos.add(generateEachLotto());
        }
        return lottos;
    }

    private Lotto generateEachLotto() {
        return new Lotto(getRandomNumber());
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
