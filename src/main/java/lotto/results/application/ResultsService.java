package lotto.results.application;

import lotto.checker.domain.Lotto;
import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.WinningNumbers;
import lotto.results.domain.Result;
import lotto.results.domain.Results;
import lotto.results.dto.ResultsRequest;

import java.util.List;

public class ResultsService {

    public Results calculateResults(ResultsRequest request) {
        List<Result> resultList = request.getLottos()
                .stream()
                .map(lotto -> getResult(
                        request.getWinningNumbers(),
                        request.getBonusNumber(),
                        lotto))
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
