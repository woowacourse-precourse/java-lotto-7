package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;

public class LottoService {

    public Lottos generateLottos(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
