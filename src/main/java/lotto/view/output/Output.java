package lotto.view.output;

import lotto.domain.Lottos;
import lotto.service.ResultCalculator;

public interface Output {
    void printLottoCount(int lottoCount);
    void printLottoNumbers(Lottos lottos);
    void printWinningDetails(ResultCalculator resultCalculator);
    void printYield(double yield);
    void printExceptionMessage(String exceptionMessage);
}
