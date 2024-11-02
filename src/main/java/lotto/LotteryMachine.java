package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class LotteryMachine {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final List<LottoResult> lottoResults = new ArrayList<>();
    private boolean isDrawn;

    public LotteryMachine(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void draw(Lottos lottos) {
        for (Lotto lotto : lottos.toUnmodifiableList()) {
            int countMatchNumbers = lotto.countMatchNumbers(winningNumbers);
            boolean matchBonusNumber = lotto.matchBonusNumber(bonusNumber);

            this.lottoResults.add(LottoResult.createResult(countMatchNumbers, matchBonusNumber));
        }

        completeDraw();
    }

    private void completeDraw() {
        this.isDrawn = true;
    }

    private boolean drawnNotYet() {
        return !alreadyDrawn();
    }

    private boolean alreadyDrawn() {
        return this.isDrawn;
    }
}