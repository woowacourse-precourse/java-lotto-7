package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class RandomLottoGenerator implements LottoNumberGenerator {
    private static final int LOTTO_PRICE = 1000;

    @Override
    public List<Lotto> generate(int amount) {
        int count = amount / LOTTO_PRICE;
        return createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(createNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
