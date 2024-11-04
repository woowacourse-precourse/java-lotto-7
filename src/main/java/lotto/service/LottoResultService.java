package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import lotto.domain.Prize;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PublishLotto;

public class LottoResultService {

    public Map<Prize, Integer> calculatePrize(Lotto winningLotto, BonusNumber bonusNumber,
        Set<PublishLotto> publishLottos) {
        Map<Prize, Integer> prizeCounts = initializePrizeCounts();

        for (PublishLotto publishLotto : publishLottos) {
            Prize prize = getPrizeForLotto(winningLotto, bonusNumber, publishLotto);
            prizeCounts.put(prize, prizeCounts.get(prize) + 1);
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

    private Prize getPrizeForLotto(Lotto winningLotto, BonusNumber bonusNumber,
        PublishLotto publishLotto) {
        int matchCount = getMatchCount(winningLotto, publishLotto);
        boolean bonusMatch = isBonusMatched(bonusNumber, publishLotto);
        return Prize.getPrize(matchCount, bonusMatch);
    }

    private int getMatchCount(Lotto winningLotto, PublishLotto publishLotto) {
        int matchCount = 0;
        for (int number : publishLotto.getPublishLottoNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isBonusMatched(BonusNumber bonusNumber, PublishLotto publishLotto) {
        return publishLotto.getPublishLottoNumbers().contains(bonusNumber.getBonusNumber());
    }

}
