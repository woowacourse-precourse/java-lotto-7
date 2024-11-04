package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public interface UserOutput {
    public void outputLottoCount(int lottoCount);

    public void outputStatistics(List<List<Integer>> lottoNumbers);

    public void outputMatchResult(Map<String, Integer> lottoMatchCount);

    public void outputProfitRate(double profitRate);
}
