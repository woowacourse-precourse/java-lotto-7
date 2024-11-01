package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int INTEGER_UNDER_BOUND = 1;
    private static final int INTEGER_UPPER_BOUND = 45;
    private static final int NUMBER_COUNT = 6;

    private final List<List<Integer>> Lottos = new ArrayList<>();

    public LottoGenerator(int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(INTEGER_UNDER_BOUND,INTEGER_UPPER_BOUND,NUMBER_COUNT);
            Lotto lotto = new Lotto(numbers);
            Lottos.add(lotto.getNumbers());
        }
    }

    public List<List<Integer>> getLottos() {
        return Lottos;
    }
}
