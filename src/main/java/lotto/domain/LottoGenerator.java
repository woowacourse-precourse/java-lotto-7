package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public Lottos createLottos(int createLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < createLottoCount; i++) {
            lottos.add(createRandomLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto createRandomLotto() {
        List<LottoNumber> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
