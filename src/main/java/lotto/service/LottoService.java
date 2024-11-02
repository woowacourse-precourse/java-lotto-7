package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    public Lottos issueLottos(int count) {
        List<Lotto> newLottos = IntStream.range(0, count)
                .mapToObj(i -> issueLotto())
                .toList();
        return new Lottos(newLottos);
    }

    private Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
        return new Lotto(numbers);
    }
}
