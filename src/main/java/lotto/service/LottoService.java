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

    private final List<Lotto> purchasedLottos;
    private final LottoResult lottoResult;

    public LottoService(List<Lotto> purchasedLottos, LottoResult lottoResult) {
        this.purchasedLottos = purchasedLottos;
        this.lottoResult = lottoResult;
    }

    public Price getPurchasePrice(String input) {
        return new Price(input);
    }

    public void buyLotto(Price purchasePrice) {
        for (int i = 0; i < purchasePrice.getLottoAmount(); i++) {
            purchasedLottos.add(generateLottoByNumbers(generateRandomNumbers()));
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(purchasedLottos);
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
        for (Lotto lotto : purchasedLottos) {
            int lottoScore = lotto.countMatchNumbers(winNumbers);
            boolean hasBonusNumber = lotto.checkHasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.evaluate(lottoScore, hasBonusNumber);

            if (rank != LottoRank.MISS) {
                Integer i = result.get(rank);
                result.put(rank, ++i);
            }
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult.getResult());
    }

    public float getProfitRate(Price price) {
        int profit = lottoResult.getResult().entrySet()
            .stream()
            .filter(e -> e.getValue() != 0)
            .mapToInt(e -> e.getKey().getPrize() * e.getValue())
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
