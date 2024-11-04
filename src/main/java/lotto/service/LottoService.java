package lotto.service;

import java.util.List;
import lotto.dto.LottoStatisticsDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRankEvaluator;
import lotto.model.LottoResult;
import lotto.model.LottoShop;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoService {

    private final LottoShop lottoShop = new LottoShop();

    public Lottos buyLottos(int price) {
        return lottoShop.buy(price);
    }

    public LottoResult getStatistics(WinningLotto winningLotto, Lottos lottos) {
        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
        LottoResult lottoResult = new LottoResult();
        lottos.getLottos()
                .forEach(lotto -> lottoResult.putResult(lottoRankEvaluator.evaluateRank(lotto)));
        return lottoResult;
    }

    public WinningLotto generateWinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Lotto generateLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public BonusNumber generateBonusNumber(Integer bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

}
