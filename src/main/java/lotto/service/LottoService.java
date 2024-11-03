package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

public interface LottoService {

    void addLottoList(int amount, List<Integer> winNumbers, int bonusNumber);

    List<Lotto> getLottoList();

    void getLottoResult(Result result, List<Integer> winNumbers, int bonusNumber);
}
