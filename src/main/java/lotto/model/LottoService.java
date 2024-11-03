package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    public List<Lotto> pickLottoNumbers(int lottoCount) {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
            .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
            .toList();
        lottos.forEach(lotto -> lotto.getNumbers().sort(null));
        return lottos;
    }


}
