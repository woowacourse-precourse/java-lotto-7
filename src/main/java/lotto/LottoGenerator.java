package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int NUMBER_LOWER_BOUND = 1;
    private static final int NUMBER_UPPER_BOUND = 45;

    public Lottos createLottos(int purchaseCount) {
        List<Lotto> lottoGroup = new ArrayList<>();

        IntStream.range(0, purchaseCount)
                .forEach(count -> lottoGroup.add(createLotto(createNumbers())));

        return new Lottos(lottoGroup);
    }

    public Lotto createLotto(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public List<LottoNumber> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND,
                Constants.LOTTO_SIZE);

        return sortAscending(numbers).stream().map(LottoNumber::from).toList();
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
