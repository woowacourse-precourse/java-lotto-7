package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final List<List<Integer>> Lottos = new ArrayList<>();

    public LottoGenerator(int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numbers);
            Lottos.add(lotto.getNumbers());
        }
    }

    public List<List<Integer>> getLottos() {
        return Lottos;
    }
}
