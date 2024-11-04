package lotto.application.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.service.WinningLottoEvaluator;
import lotto.domain.lotto.vo.LottoPrize;

public class EvaluateWinningLottoCommand implements EvaluateWinningLottoUsecase {

    private final WinningLottoEvaluator winningLottoEvaluator;

    public EvaluateWinningLottoCommand(WinningLottoEvaluator winningLottoEvaluator) {
        this.winningLottoEvaluator = winningLottoEvaluator;
    }

    @Override
    public List<LottoPrize> execute(WinningNumber winningNumber, List<Lotto> lottos) {
        return lottos.stream()
            .map(lotto -> winningLottoEvaluator.evaluate(winningNumber, lotto))
            .collect(Collectors.toList());
    }

}
