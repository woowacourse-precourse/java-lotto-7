package lotto.service;

import java.util.List;
import lotto.domain.dto.LottoResult;
import lotto.service.dto.SellLotto;

public interface LottoService {

    SellLotto sellLotto(int money);
    void createWinningNumber(List<Integer> winningNumbers);
    void createBonusNumber(int bonusNumber);
    LottoResult compareWinningNumbers();
}
