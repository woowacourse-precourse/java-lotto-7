package lotto.service;

import java.util.List;

public interface LottoService {

    double computeProfitRate(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber);
}
