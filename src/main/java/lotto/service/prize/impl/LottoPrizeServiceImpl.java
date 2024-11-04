package lotto.service.prize.impl;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.domain.LottoPrize;
import lotto.service.prize.LottoPrizeService;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPrizeServiceImpl implements LottoPrizeService {

    @Override
    public List<LottoPrize> getLottoPrizes(List<Lotto> lottoBundle, LottoDrawResult drawResult) {
        Lotto drewLotto = drawResult.getDrewLotto();
        Integer bonusNumber = drawResult.getBonusNumber();

        return lottoBundle.stream()
                .map(lotto -> {
                    int matchCount = lotto.getMatchCount(drewLotto);
                    boolean hasBonus = lotto.containNumber(bonusNumber);
                    return LottoPrize.fromMatchCount(matchCount, hasBonus);
                })
                .collect(Collectors.toList());
    }
}
