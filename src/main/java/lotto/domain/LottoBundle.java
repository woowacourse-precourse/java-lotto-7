package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottos;
    private final int lottoPrice;

    private LottoBundle(List<Lotto> lottos, int lottoPrice) {
        this.lottos = lottos;
        this.lottoPrice = lottoPrice;
    }

    public static LottoBundle from(List<Lotto> lottos, int lottoPrice) {
        return new LottoBundle(lottos, lottoPrice);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult makeLottoResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = checkLottoRank(winningLotto, bonusNumber);
        double totalPrizeMoney = sumLottoPrizeMoney(lottoRanks);

        return new LottoResult(lottoRanks, lottoPrice, totalPrizeMoney);
    }

    private List<LottoRank> checkLottoRank(WinningLotto winningLotto, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> LottoRank.findLottoRank(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private double sumLottoPrizeMoney(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(lottoRank -> lottoRank.getPrizeMoney())
                .sum();
    }
}
