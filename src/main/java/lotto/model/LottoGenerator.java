package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    private Lotto buildLotto(List<Integer> orderedNumbers) {
        return Lotto.createUserLotto(orderedNumbers);
    }

    private List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> createSingleLotto())
                .toList();

        return lottos;
    }
}
