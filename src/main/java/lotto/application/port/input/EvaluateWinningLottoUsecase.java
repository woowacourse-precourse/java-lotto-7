package lotto.application.port.input;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;

public interface EvaluateWinningLottoUsecase {

    void execute(WinningNumber winningNumber, List<Lotto> lottos);
}
