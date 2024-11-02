package lotto.service.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningResult;

import java.util.List;

public interface LottoService {
    boolean validateAmount(int amount);
    WinningResult checkResult(List<Lotto> lottos, WinningContext context);
    double calculateEarningsRate(int totalPrize, int amount);
    List<Lotto> generateLottos(int amount);
}
