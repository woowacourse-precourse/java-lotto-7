package lotto.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.Price;

public class ResultService {

    private final LottoResult lottoResult;

    public ResultService(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Numbers getWinNumbers(String input) {
        return new Numbers(input);
    }

    public Number getBonusNumber(Numbers winNumbers, String input) {
        Number bonusNumber = new Number(input);
        Number.validateBonusNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }

    public void calculateLottoResult(List<Lotto> purchasedLotteries, Numbers winNumbers, Number bonusNumber) {
        Map<LottoRank, Integer> result = lottoResult.getResult();
        for (Lotto lotto : purchasedLotteries) {
            int lottoScore = lotto.countMatchNumbers(winNumbers);
            boolean hasBonusNumber = lotto.checkHasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.evaluate(lottoScore, hasBonusNumber);

            if (rank != LottoRank.MISS) {
                Integer rankResult = result.get(rank);
                result.put(rank, ++rankResult);
            }
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult.getResult());
    }

    public float getProfitRate(Price price) {
        return ((float) lottoResult.calculateProfit() / price.value()) * 100;
    }
}
