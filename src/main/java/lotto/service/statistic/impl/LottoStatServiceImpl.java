package lotto.service.statistic.impl;

import lotto.domain.LottoPrize;
import lotto.domain.LottoStats;
import lotto.service.statistic.LottoStatService;

import java.util.List;

public class LottoStatServiceImpl implements LottoStatService {

    @Override
    public LottoStats getLottoStats(List<LottoPrize> lottoPrizes, int money) {

        return new LottoStats(lottoPrizes, money);
    }
}
