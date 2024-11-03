package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import java.util.List;

public class LottoService {
    public Lottos generateLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Lotto generateLotto (List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
