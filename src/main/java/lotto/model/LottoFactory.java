package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public List<Lotto> createLottos(Money money) {
        return IntStream.range(0, money.getLottoCount())
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
