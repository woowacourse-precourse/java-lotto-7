package lotto.view.outputview;

import java.util.List;
import java.util.Map;

public interface Result {
    void responseCntLotto(int cnt);
    void responseLottoNumberList(List<List<Integer>> lottoNumbersList);
    void displayWinningStatistics();
    void winningResult(Map<String, Integer> matchCounts);
    void totalPrize(double yield);
}
