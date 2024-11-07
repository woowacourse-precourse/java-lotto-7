package lotto.domain.lotto;

import lotto.domain.Prize;
import lotto.domain.PurchaseAmount;
import lotto.dto.WinningSummaryResponse;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATED;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningSummaryResponse findWinningResult(List<Lotto> purchasedLottos, PurchaseAmount purchaseAmount) {
        Map<Prize, Integer> winningSummary = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            winningSummary.put(prize, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            Prize prize = findPrize(lotto);
            winningSummary.merge(prize, 1, Integer::sum);
        }

        return WinningSummaryResponse.from(winningSummary, calculateProfitRate(purchaseAmount, winningSummary));
    }

    private Prize findPrize(Lotto lotto) {
        int matchingNumberCount = (int) winningLotto.getNumbers()
                .stream()
                .filter(lotto::contains)
                .count();

        boolean containsBonusNumber = containsBonusNumberIn(lotto);
        if (containsBonusNumber) {
            matchingNumberCount++;
        }

        return Prize.of(matchingNumberCount, containsBonusNumber);
    }

    private double calculateProfitRate(PurchaseAmount purchaseAmount, Map<Prize, Integer> winningSummary) {
        int totalProfit = winningSummary.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return ((double) totalProfit / purchaseAmount.getAmount()) * 100;
    }

    private boolean containsBonusNumberIn(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        validateUnique(winningLotto, bonusNumber);
    }

    private void validateUnique(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }
}
