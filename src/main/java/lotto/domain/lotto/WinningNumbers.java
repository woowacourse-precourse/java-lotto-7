package lotto.domain.lotto;

import lotto.domain.Prize;
import lotto.dto.WinningSummaryResponse;

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

    public WinningSummaryResponse findWinningResult(List<Lotto> purchasedLottos) {
        Map<Prize, Integer> WinningSummary = new HashMap<>();
        for (Prize prize : Prize.values()) {
            WinningSummary.put(prize, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            Prize prize = findPrize(lotto);
            WinningSummary.merge(prize, 1, Integer::sum);
        }

        return WinningSummaryResponse.from(WinningSummary);
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
