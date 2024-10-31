package lotto.model;

import lotto.dto.LottoStatisticDTO;

import java.util.List;
import java.util.Map;

public interface LottoStatistics {

    public void updateStatistics(List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber);

    public void updateLottoYield(int purchaseAmount);

    public LottoStatisticDTO toDTO();
}
