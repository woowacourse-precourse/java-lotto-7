package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private static final int LOTTO_BEGIN_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_BEGIN_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
        List<Integer> sortedNumbers = numbers.stream()
                                            .sorted()
                                            .collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }
}
