package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottos = generateLottos(lottoCount);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
