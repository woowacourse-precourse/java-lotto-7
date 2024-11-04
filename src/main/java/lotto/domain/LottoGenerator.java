package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static Lottos generateLottos(int lottoAmount) {
        List<Lotto> lottos = IntStream.range(0, lottoAmount)
                .mapToObj(it -> generateLotto())
                .toList();

        return new Lottos(lottos);
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.LOTTO_NUMBER_MIN,
                LottoNumber.LOTTO_NUMBER_MAX,
                Lotto.LOTTO_NUMBERS_SIZE);

        return new Lotto(numbers);
    }
}
