package lotto.model;
import lotto.dto.LottoStatisticDTO;
import java.util.List;

public interface LottoStatistics {
    void updateStatistics(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber);

    void updateLottoYield();

    LottoStatisticDTO toDTO();
}
