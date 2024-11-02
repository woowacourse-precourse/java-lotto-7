package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoError;
import lotto.enums.LottoRank;

public class LottoBundle {
    private final List<Lotto> lottos;
    private final LottoPurchasePrice lottoPurchasePrice;

    private LottoBundle(List<Lotto> lottos, LottoPurchasePrice lottoPurchasePrice) {
        validateLottoCount(lottos, lottoPurchasePrice);
        this.lottos = lottos;
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public static LottoBundle ofLottosAndPurchasePrice(List<Lotto> lottos, LottoPurchasePrice lottoPurchasePrice) {
        return new LottoBundle(lottos, lottoPurchasePrice);
    }

    private void validateLottoCount(List<Lotto> lottos, LottoPurchasePrice lottoPurchasePrice) {
        if (lottos.size() != lottoPurchasePrice.getLottoCount()) {
            throw new IllegalArgumentException(LottoError.LOTTO_BUNDLE_LOTTOS_COUNT_INVALID.getMessage());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult makeLottoResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = checkLottoRank(winningLotto, bonusNumber);
        double totalPrizeMoney = sumLottoPrizeMoney(lottoRanks);
        double lottoProfitRate = lottoPurchasePrice.calculateProfit(totalPrizeMoney);

        return LottoResult.ofRanksAndProfitRate(lottoRanks, lottoProfitRate);
    }

    private List<LottoRank> checkLottoRank(WinningLotto winningLotto, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private double sumLottoPrizeMoney(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(LottoRank::getPrizeMoney)
                .sum();
    }
}
