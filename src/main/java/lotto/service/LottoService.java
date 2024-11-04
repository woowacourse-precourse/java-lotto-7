package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.Price;

public class LottoService {

    private final List<Lotto> purchasedLotteries;
    private final LottoResult lottoResult;

    public LottoService(List<Lotto> purchasedLotteries, LottoResult lottoResult) {
        this.purchasedLotteries = purchasedLotteries;
        this.lottoResult = lottoResult;
    }

    public Price getPurchasePrice(String input) {
        return new Price(input);
    }

    public void buyLotto(Price purchasePrice) {
        for (int i = 0; i < purchasePrice.getLottoAmount(); i++) {
            purchasedLotteries.add(generateLottoByNumbers(generateRandomNumbers()));
        }
    }

    public List<Lotto> getPurchasedLotteries() {
        return Collections.unmodifiableList(purchasedLotteries);
    }

    public Numbers getWinNumbers(String input) {
        return new Numbers(input);
    }

    public Number getBonusNumber(Numbers winNumbers, String input) {
        Number bonusNumber = new Number(input);
        Number.validateBonusNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }

    public void calculateLottoResult(Numbers winNumbers, Number bonusNumber) {
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
        int profit = lottoResult.getResult().entrySet()
            .stream()
            .filter(result -> result.getValue() != 0)
            .mapToInt(result -> result.getKey().getPrize() * result.getValue())
            .sum();

        return ((float) profit / price.value()) * 100;
    }

    private Lotto generateLottoByNumbers(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
