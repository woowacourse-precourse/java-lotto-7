package lotto.domain.lotto;

import lotto.domain.Prize;
import lotto.dto.PrizeResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATED;

public class WinningLottoWithBonus {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLottoWithBonus(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<PrizeResponse> findWinningResult(List<Lotto> purchasedLottos) {
        Map<Prize, Integer> winningCounts = new HashMap<>();
        for (Prize prize : Prize.values()) {
            winningCounts.put(prize, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            Prize prize = findPrize(lotto);
            winningCounts.merge(prize, 1, Integer::sum);
        }

        return mapResponse(winningCounts);
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

    private List<PrizeResponse> mapResponse(Map<Prize, Integer> winningCounts) {
        return Arrays.stream(Prize.values())
                .map(prize -> new PrizeResponse(prize, winningCounts.get(prize)))
                .toList();
    }

    private boolean containsBonusNumberIn(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        validateUnique(winningLotto, bonusNumber);
    }

    public void validateUnique(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }
}
