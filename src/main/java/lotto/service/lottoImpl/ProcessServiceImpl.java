package lotto.service.lottoImpl;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoWinningNumber;

import java.util.List;

public interface ProcessServiceImpl {
    LottoResult matchNumber(List<Lotto> lottos, LottoWinningNumber winningNumbers);

    String calculateRate(int tickets, LottoResult result);
}
