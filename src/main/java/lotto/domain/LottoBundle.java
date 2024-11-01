package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoConfig;
import lotto.enums.LottoRank;

public class LottoBundle {
    private final List<Lotto> lottos;
    private final LottoConfig lottoConfig;

    private LottoBundle(List<Lotto> lottos, LottoConfig lottoConfig) {
        this.lottos = lottos;
        this.lottoConfig = lottoConfig;
    }

    public static LottoBundle ofLottosAndConfig(List<Lotto> lottos, LottoConfig lottoConfig) {
        return new LottoBundle(lottos, lottoConfig);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult makeLottoResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = checkLottoRank(winningLotto, bonusNumber);
        double totalPrizeMoney = sumLottoPrizeMoney(lottoRanks);

        return LottoResult.ofLottoRanksAndLottoPriceAndTotalPrizeMoney(
                lottoRanks, lottoConfig.getLottoPrice(), totalPrizeMoney);
    }

    private List<LottoRank> checkLottoRank(WinningLotto winningLotto, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private double sumLottoPrizeMoney(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(lottoRank -> lottoRank.getPrizeMoney())
                .sum();
    }
}
