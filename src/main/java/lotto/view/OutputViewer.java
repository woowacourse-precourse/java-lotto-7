package lotto.view;
import lotto.dto.LottoStatisticDTO;
import lotto.model.Lotto;
import java.util.List;

public interface OutputViewer {
    void printLottoInitSummary(LottoStatisticDTO lottoStatistic, List<Lotto> randomLotteries);

    void printLottoResult(LottoStatisticDTO lottoStatisticDTO);

}
