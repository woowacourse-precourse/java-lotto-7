package lotto.service;

import java.util.List;
import lotto.controller.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseHistory;
import lotto.model.lottoInfo.LottoGame;

public class LottoService {
    public LottoPurchaseHistory buyLotto(int amount) {
        return new LottoPurchaseHistory(amount);
    }

    public LottoResult playLottoGame(LottoGame lottoGame, LottoPurchaseHistory lottoPurchaseHistory) {
        List<Lotto> purchasedLotto = lottoPurchaseHistory.getPurchaseHistory();

        return new LottoResult(purchasedLotto.stream()
                .map(lotto -> lottoGame.calculateRank(lotto.getNumbers()))
                .toList());
    }
}
