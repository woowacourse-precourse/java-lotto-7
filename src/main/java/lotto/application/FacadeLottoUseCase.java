package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinResult;

public interface FacadeLottoUseCase {

    void purchase(Money money);

    List<Lotto> retrieveAll();

    void createWinLotto(List<Integer> numbers, int bonusNumber);

    void checkWinning();

    WinResult getWinResult();

    float calculateProfitRate();
}
