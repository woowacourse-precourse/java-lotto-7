package lotto.io;

import java.util.Map;

import lotto.lotto.LottoAmount;
import lotto.lotto.Lottos;
import lotto.lotto.Rank;

public interface OutputHandler {

    void printLotto(Lottos lottos, LottoAmount lottoAmount);

    void printResult(Map<Rank, Integer> rankSummary, double profitRate);
}
