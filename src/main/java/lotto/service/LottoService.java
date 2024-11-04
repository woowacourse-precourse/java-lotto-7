package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.controller.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseHistory;
import lotto.model.lottoInfo.LottoGame;

public class LottoService {
    private static final Integer PERCENT = 100;

    public LottoPurchaseHistory buyLotto(int amount) {
        return new LottoPurchaseHistory(amount);
    }

    public LottoResult playLottoGame(LottoGame lottoGame, LottoPurchaseHistory lottoPurchaseHistory) {
        List<Lotto> purchasedLotto = lottoPurchaseHistory.getPurchaseHistory();

        return new LottoResult(purchasedLotto.stream()
                .map(lotto -> lottoGame.calculateRank(lotto.getNumbers()))
                .toList());
    }

    public BigDecimal calculatePrizeRate(LottoGame lottoGame, LottoResult lottoResult, int money) {
        long totalPrize = lottoGame.calculateTotalPrize(lottoResult.ranks());

        return BigDecimal.valueOf(totalPrize)
                .multiply(BigDecimal.valueOf(PERCENT))
                .divide(BigDecimal.valueOf(money), 2, RoundingMode.HALF_UP);
    }
}
