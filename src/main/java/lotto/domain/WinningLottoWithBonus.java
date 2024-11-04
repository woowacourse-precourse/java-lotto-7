package lotto.domain;

import lotto.dto.PrizeResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoWithBonus {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLottoWithBonus(Lotto winningLotto, LottoNumber bonusNumber) {
        validate();
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

    public void validate() {
        validateUnique();
    }

    public void validateUnique() {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
