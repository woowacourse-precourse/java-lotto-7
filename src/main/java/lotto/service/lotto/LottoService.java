package lotto.service.lotto;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {

    int LOTTO_START = 1;
    int LOTTO_END = 45;
    int LOTTO_TOTAL_COUNT = 6;

    List<Lotto> createLottoBundle(int purchaseCount);
    Lotto createLotto(List<Integer> numbers);


}