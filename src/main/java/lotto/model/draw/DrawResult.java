package lotto.model.draw;

import static lotto.model.draw.Prize.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;

public class DrawResult {

    public final Map<Prize, Integer> drawResult = new HashMap<>();

    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;
    private final LottoTicket lottoTicket;

    private DrawResult(WinningLotto winningLotto, BonusNumber bonusNumber, LottoTicket lottoTicket) {
        initDrawResult();
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottoTicket = lottoTicket;
    }

    public static DrawResult of(WinningLotto winningLotto, BonusNumber bonusNumber, LottoTicket lottoTicket) {
        return new DrawResult(winningLotto, bonusNumber, lottoTicket);
    }

    private void initDrawResult() {
        Prize[] prizes = values();
        Arrays.stream(prizes).forEach(
                prize -> { drawResult.put(prize, 0); }
        );
    }

    public void generateDrawResult() {
        List<Lotto> lottos = lottoTicket.getLottos();
        for (Lotto lotto : lottos) {
            checkPrize(lotto);
        }
    }

    private void checkPrize(Lotto lotto) {
        int sameNumberCount = lotto.countSameNumber(winningLotto.getWinningLotto());

        boolean isContainBonusNumber = lotto.isContain(bonusNumber.getNumber());

        Prize prize = findPrize(sameNumberCount, isContainBonusNumber);

        updatePrizeCount(prize);
    }

    private void updatePrizeCount(Prize prize) {
        Integer currentWinningCount = drawResult.getOrDefault(prize, 0);
        drawResult.put(prize, currentWinningCount + 1);
    }

    public Map<Prize, Integer> getDrawResult() {
        return drawResult;
    }
}
