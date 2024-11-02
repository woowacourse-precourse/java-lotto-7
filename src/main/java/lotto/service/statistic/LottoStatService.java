package lotto.service.statistic;

import lotto.domain.LottoPrize;
import lotto.domain.LottoStats;

import java.util.List;

public interface LottoStatService {

    LottoStats getLottoStats(List<LottoPrize> lottoPrizes, int money);

}
