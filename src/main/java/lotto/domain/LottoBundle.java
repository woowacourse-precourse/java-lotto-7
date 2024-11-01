package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoConfig;
import lotto.enums.LottoRank;

public class LottoBundle {
    private final List<Lotto> lottos;
    private final LottoPurchasePrice lottoPurchasePrice;
    private final LottoConfig lottoConfig;

    private LottoBundle(List<Lotto> lottos, LottoPurchasePrice lottoPurchasePrice, LottoConfig lottoConfig) {
        this.lottos = lottos;
        this.lottoPurchasePrice = lottoPurchasePrice;
        this.lottoConfig = lottoConfig;
    }

    public static LottoBundle ofLottosAndPurchasePriceAndConfig(
            List<Lotto> lottos, LottoPurchasePrice lottoPurchasePrice, LottoConfig lottoConfig) {
        return new LottoBundle(lottos, lottoPurchasePrice, lottoConfig);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult makeLottoResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = checkLottoRank(winningLotto, bonusNumber);
        double totalPrizeMoney = sumLottoPrizeMoney(lottoRanks);
        LottoProfit lottoProfit = lottoPurchasePrice.calculateProfit(totalPrizeMoney);

        return LottoResult.ofLottoRanksAndProfit(lottoRanks, lottoProfit);
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
