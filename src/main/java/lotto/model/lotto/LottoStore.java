package lotto.model.lotto;

import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;
import lotto.model.lotto.prize.LottoPrizeInfo;

public class LottoStore {
    private final Long purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoStore(Long amount) {
        this(new RandomLottoGenerator(), amount);
    }

    public LottoStore(LottoGenerator lottoGenerator, long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        int lottoCount = (int) (purchaseAmount / LOTTO_PURCHASE_AMOUNT);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.generateLotto(lottoGenerator));
        }
    }

    public Double computeProfitRate(Lotto winningLotto, Integer bonusNumber) {
        Long totalPrize = calculateTotalPrize(winningLotto, bonusNumber);
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private Long calculateTotalPrize(Lotto winningLotto, Integer bonusNumber) {
        Map<LottoPrizeInfo, Integer> prizeCounts = getPrizeCounts(winningLotto, bonusNumber);
        return prizeCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    private Map<LottoPrizeInfo, Integer> getPrizeCounts(Lotto winningLotto, Integer bonusNumber) {
        Map<LottoPrizeInfo, Integer> prizeCounts = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean hasBonus = lotto.hasBonus(bonusNumber);

            LottoPrizeInfo prizeInfo = LottoPrizeInfo.getPrizeByMatch(matchCount, hasBonus);
            prizeCounts.put(prizeInfo, prizeCounts.getOrDefault(prizeInfo, 0) + 1);
        }

        return prizeCounts;
    }

    private void validatePurchaseAmount(long amount) {
        if (amount % LOTTO_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PURCHASE_AMOUNT + "원 단위여야 합니다.");
        }
    }
}
