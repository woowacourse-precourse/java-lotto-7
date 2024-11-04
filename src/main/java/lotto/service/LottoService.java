package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;

public interface LottoService {

    void addLottoes(int amount, List<Integer> winNumbers, int bonusNumber);

    List<Lotto> getLottoes();

    void getLottoResult(Result result, List<Integer> winNumbers, int bonusNumber);
}
