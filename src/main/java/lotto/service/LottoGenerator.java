package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoGenerator {
    private final Supplier<List<Integer>> randomNumbers;
    private static final Integer PRICE_UNIT = 1000;
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private static final Integer TOTAL_COUNT = 6;

    public LottoGenerator() {
        this( () -> Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, TOTAL_COUNT));
    }

    public LottoGenerator(Supplier<List<Integer>> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = randomNumbers.get();
        return new Lotto(numbers);
    }

    public Lottos generateLottos(Integer price) {
        List<Lotto> lottos = new ArrayList<>();
        int count = price / PRICE_UNIT;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

}
