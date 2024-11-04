package lotto.application.port.input;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.vo.LottoPrize;

public interface EvaluateWinningLottoUsecase {

    List<LottoPrize> execute(WinningNumber winningNumber, List<Lotto> lottos);
}
