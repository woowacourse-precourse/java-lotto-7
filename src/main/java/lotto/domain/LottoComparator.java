package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {

    private static final String BONUS_NUMBER_DUPLICATE_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final List<Lotto> lottos; // 로또 티켓
    private final Lotto winningLotto; // 당첨 번호
    private final int bonusNumber; // 보너스 번호

    public LottoComparator(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> getLottoResults() {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto);
            boolean isBonusMatch = isBonusNumberMatched(lotto);
            lottoResults.add(new LottoResult(matchCount, isBonusMatch));
        }

        return lottoResults;
    }

    private int getMatchCount(Lotto userLotto) {
        int matchCount = 0;

        for (Integer number : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }

}
