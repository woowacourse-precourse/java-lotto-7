package lotto.io;

import java.util.List;
import java.util.Map;

public interface OutputHandler {
    void showLottoPrice();

    void showLottoCount(int lottoCount);

    void showLottoList(List<Integer> numbers);

    void showWinningNumbersMessage();

    void showBonusNumberMessage();

    void showMatchResult(Map<String, Integer> matchResults, double profitRate);
}
