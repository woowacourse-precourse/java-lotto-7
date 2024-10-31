package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoBundle of(List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult makeLottoResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = lottos.stream()
                .map(lotto -> LottoRank.findLottoRank(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());

        LottoResult lottoResult = new LottoResult(lottoRanks);
        return lottoResult;
    }
}
