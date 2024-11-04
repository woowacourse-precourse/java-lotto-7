package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> generateLotto(String purchaseAmount) {
        int lottoCount = Integer.parseInt(purchaseAmount) / 1000;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

}
