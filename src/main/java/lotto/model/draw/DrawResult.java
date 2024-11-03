package lotto.model.draw;

import static lotto.model.draw.Prize.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;

public class DrawResult {

    private static final int INIT_COUNT = 0;

    private final Map<Prize, Integer> drawResult;
    private final WinningLottoTicket winningLottoTicket;
    private final LottoTicket lottoTicket;

    private DrawResult(WinningLottoTicket winningLottoTicket, LottoTicket lottoTicket) {
        drawResult = new TreeMap<>((o1, o2) -> o2.getRank() - o1.getRank());
        initDrawResult();
        this.winningLottoTicket = winningLottoTicket;
        this.lottoTicket = lottoTicket;
    }

    public static DrawResult of(WinningLottoTicket winningLottoTicket, LottoTicket lottoTicket) {
        return new DrawResult(winningLottoTicket, lottoTicket);
    }

    private void initDrawResult() {
        Prize[] prizes = values();
        Arrays.stream(prizes).forEach(
                prize -> { drawResult.put(prize, INIT_COUNT); }
        );
    }

    public void generateDrawResult() {
        List<Lotto> ticket = lottoTicket.getLottos();
        for (Lotto lotto : ticket) {
            checkPrize(lotto);
        }
    }

    private void checkPrize(Lotto lotto) {
        int sameNumberCount = winningLottoTicket.countSameNumber(lotto);
        boolean isContainBonusNumber = winningLottoTicket.isContainBonusNumber(lotto);
        Prize prize = findPrize(sameNumberCount, isContainBonusNumber);
        updatePrizeCount(prize);
    }

    private void updatePrizeCount(Prize prize) {
        Integer currentWinningCount = drawResult.getOrDefault(prize, INIT_COUNT);
        drawResult.put(prize, currentWinningCount + 1);
    }

    public int calculateTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        Set<Prize> prizes = drawResult.keySet();
        for (Prize prize : prizes) {
            totalPrizeMoney += prize.calculatePrizeMoney(drawResult.get(prize));
        }
        return totalPrizeMoney;
    }

    public Map<Prize, Integer> getDrawResult() {
        return drawResult;
    }

}
