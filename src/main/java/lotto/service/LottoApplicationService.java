package lotto.service;

import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.winning.WinningContext;
import lotto.domain.model.winning.WinningResult;

import java.util.List;

public interface LottoApplicationService {
    boolean validateAmount(String input);
    WinningResult result(List<Lotto> lottos, WinningContext context);
    double calculateEarningsRate(int totalPrize, int amount);
    List<Lotto> generateLottos(int amount);
}
