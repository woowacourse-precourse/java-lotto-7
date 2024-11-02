package lotto.model;
import lotto.dto.LottoStatisticDTO;
import java.util.List;

public interface LottoStatistics {
    public void updateStatistics(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber);

    public void updateLottoYield();

    public LottoStatisticDTO toDTO();
}
