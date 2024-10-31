package lotto;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int NUMBER_LOWER_BOUND = 1;
    private static final int NUMBER_UPPER_BOUND = 45;
    private static final int LOTTO_PICK_COUNT = 6;

    public Lottos createLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(0, purchaseCount)
                .forEach(count -> lottos.add(createLotto(createLottoNumbers())));

        return new Lottos(lottos);
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND,
                LOTTO_PICK_COUNT);
        sortNumbers(numbers);
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        sort(numbers);
    }
}
