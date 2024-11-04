package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Limit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    private Lotto buildLotto(List<Integer> orderedNumbers) {
        return Lotto.createUserLotto(orderedNumbers);
    }

    private List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Limit.MIN_LOTTO_NUMBER.getValue(),
                Limit.MAX_LOTTO_NUMBER.getValue(),
                Limit.LOTTO_NUMBER_COUNT.getValue());
    }

    private List<Integer> arrangeLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public Lotto createSingleLotto() {
        List<Integer> rawLotto = createRandomLottoNumbers();
        List<Integer> sortedLotto = arrangeLottoNumbers(rawLotto);
        return buildLotto(sortedLotto);
    }

    public List<Lotto> createMultipleLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(Limit.DEFAULT.getValue(), ticketCount)
                .mapToObj(i -> createSingleLotto())
                .toList();

        return lottos;
    }
}
