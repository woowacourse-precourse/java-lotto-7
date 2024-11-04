package lotto.interaction.output;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoResult;

public interface LottoOutput {
    void printToInputPurchaseMoney();
    void printToInputWinningNumber();
    void printToInputBonusNumber();
    void printPurchasedLotto(List<Lotto> lottoList);
    void printWinningStatistics(Map<LottoResult, Integer> resultMap, double rate);
    void printErrorMessage(String message);
}
