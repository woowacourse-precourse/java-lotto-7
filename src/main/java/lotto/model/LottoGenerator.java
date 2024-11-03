package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

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

    private void arrangeLottoNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public Lotto createSingleLotto() {
        List<Integer> rawLotto = createRandomLottoNumbers();
        arrangeLottoNumbers(rawLotto);
        return buildLotto(rawLotto);
    }

    public List<Lotto> createMultipleLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> createSingleLotto())
                .toList();

        return lottos;
    }
}
