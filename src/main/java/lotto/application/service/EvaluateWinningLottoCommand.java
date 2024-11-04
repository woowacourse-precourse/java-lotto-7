package lotto.application.service;

import java.util.List;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;

public class EvaluateWinningLottoCommand implements EvaluateWinningLottoUsecase {

    @Override
    public void execute(WinningNumber winningNumber, List<Lotto> lottos) {

    }
}
