package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Prize;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PublishLotto;

public class LottoResultService {

    public Map<Prize, Integer> calculatePrize(final Lotto winningLotto,
        final BonusNumber bonusNumber,
        final List<PublishLotto> publishLottos) {
        Map<Prize, Integer> prizeCounts = initializePrizeCounts();

        for (PublishLotto publishLotto : publishLottos) {
            Prize prize = getPrizeForLotto(winningLotto, bonusNumber, publishLotto);
            if (prize != null) {
                prizeCounts.put(prize, prizeCounts.get(prize) + 1);
            }
        }

        return prizeCounts;
    }

    private Map<Prize, Integer> initializePrizeCounts() {
        Map<Prize, Integer> prizeCounts = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCounts.put(prize, 0);
        }
        return prizeCounts;
    }

    private Prize getPrizeForLotto(final Lotto winningLotto, final BonusNumber bonusNumber,
        final PublishLotto publishLotto) {
        int matchCount = getMatchCount(winningLotto, publishLotto);
        boolean bonusMatch = isBonusMatched(bonusNumber, publishLotto);
        return Prize.getPrize(matchCount, bonusMatch);
    }

    private int getMatchCount(final Lotto winningLotto, final PublishLotto publishLotto) {
        int matchCount = 0;
        for (int number : publishLotto.getPublishLottoNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isBonusMatched(final BonusNumber bonusNumber, final PublishLotto publishLotto) {
        return publishLotto.getPublishLottoNumbers().contains(bonusNumber.getBonusNumber());
    }

}
