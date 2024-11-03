package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.common.Price;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.Lottos;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;
import lotto.domain.winner.WinningStatistic;

public class LotteryMachine {

    private static final String CANNOT_MAKE_STATISTIC = "아직 추첨을 하지 않아 통게를 낼 수 없습니다.";
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

            this.lottoResults.add(new LottoResult(countMatchNumbers, matchBonusNumber));
        }

        completeDraw();
    }

    public WinningStatistic generateWinningStatisticBy(Price price) {
        if (drawnNotYet()) {
            throw new IllegalArgumentException(CANNOT_MAKE_STATISTIC);
        }

        return WinningStatistic.from(lottoResults, price);
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
