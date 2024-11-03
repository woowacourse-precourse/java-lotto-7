package lotto.service;

import static java.lang.Integer.parseInt;

import lotto.Lotto;
import lotto.LottoRank;

public class LottoService {

    private LottoRank calculateLottoRank(Lotto lotto, Lotto userLotto, int bonusNumber) {
        int matchCount = lotto.countMatchingNumbers(userLotto);
        boolean bonusMatch = lotto.containsNumber(bonusNumber);
        return LottoRank.findRankByMatches(matchCount, bonusMatch);
    }

    public int calculatePurchaseQuantity(String purchaseAmount) {
        return parseInt(purchaseAmount) / 1000;
    }
}
