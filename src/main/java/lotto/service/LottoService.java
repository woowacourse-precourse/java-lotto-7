package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public abstract class LottoService {
    public static List<Lotto> generateLottos(int price) {
        int count = price / 1000;
        return IntStream.range(0, count)
                .mapToObj(i -> LottoService.generateLotto())
                .toList();
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
