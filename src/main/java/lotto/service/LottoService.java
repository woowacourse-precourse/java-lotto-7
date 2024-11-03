package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {

    InputView inputView;
    OutputView outputView;
    FortuneMachine fortuneMachine;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.fortuneMachine = fortuneMachine;
    }

    public Results calculateResults(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lottos lottos) {
        List<Result> resultList = lottos.stream()
                .map(lotto -> getResult(winningNumbers, bonusNumber, lotto))
                .toList();
        return new Results(resultList);
    }

    public Result getResult(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotto lotto) {
        return Result.findByCount(countWinningNumber(winningNumbers, lotto), countBonusNumber(bonusNumber.value(), lotto));
    }

    public Integer countWinningNumber(WinningNumbers winningNumbers, Lotto lotto) {
        return Math.toIntExact(winningNumbers.getKeySet()
                .stream()
                .filter(lotto::isMatched)
                .count());
    }

    public Integer countBonusNumber(Integer bonusNumber, Lotto lotto) {
        if (lotto.isMatched(bonusNumber)) {
            return 1;
        }
        return 0;
    }


}
