package lotto.view;

import lotto.dto.LottoStatisticDTO;
import lotto.model.Lotto;

import java.util.List;

public interface OutputViewer {
    public void printLottoInitSummary(LottoStatisticDTO lottoStatistic, List<Lotto> randomLotteries);

    public void printLottoResult(LottoStatisticDTO lottoStatisticDTO);

}
