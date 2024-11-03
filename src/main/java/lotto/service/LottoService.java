package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public class LottoService {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int COUNT = 6;

    public LottoService() { }

    public Lottos generate(final int lottoCount) {
        return Lottos.from(
                IntStream.range(0, lottoCount)
                        .mapToObj(i -> generateSingleLotto())
                        .toList()
        );
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = generateRandomNumbers();
        return Lotto.from(numbers);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
