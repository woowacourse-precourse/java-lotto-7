package lotto.service.prize;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.domain.LottoPrize;

import java.util.List;

public interface LottoPrizeService {

    List<LottoPrize> getLottoPrizes(List<Lotto> lottoBundle, LottoDrawResult drawResult);

}
