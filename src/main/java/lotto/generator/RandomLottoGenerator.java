package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class RandomLottoGenerator implements LottoNumberGenerator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
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
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE)
                .stream()
                .sorted()
                .toList();
    }
}
