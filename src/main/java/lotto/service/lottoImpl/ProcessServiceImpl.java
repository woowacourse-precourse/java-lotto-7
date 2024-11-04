package lotto.service.lottoImpl;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumber;

import java.util.List;

public interface ProcessServiceImpl {
    Result matchNumber(List<Lotto> lottos, WinningNumber winningNumbers);

    String calculateRate(int tickets, Result result);
}
