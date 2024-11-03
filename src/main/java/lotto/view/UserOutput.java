package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public interface UserOutput {
    public void outputLottoCount(int lottoCount);

    public void outputStatistics(List<List<Integer>> lottoNumbers);
}
