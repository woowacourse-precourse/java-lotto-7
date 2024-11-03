package lotto.model.draw;

import static lotto.model.draw.Prize.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
// 로또 추첨 결과를 관리하는 객체
public class DrawResult {

    private static final int INIT_COUNT = 0;

    private final Map<Prize, Integer> drawResult;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;
    private final LottoTicket lottoTicket;
    // TreeMap을 이용해서 로또 추첨 결과를 관리합니다
    // TreeMap을 이용하는 이유는 TreeMap은 key를 관리할 때 순서를 가지기 때문에 당첨 순위대로 key값 관리가 가능하다!
    private DrawResult(WinningLotto winningLotto, BonusNumber bonusNumber, LottoTicket lottoTicket) {
        drawResult = new TreeMap<>((o1, o2) -> o2.getRank() - o1.getRank());
        initDrawResult();
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottoTicket = lottoTicket;
    }

    public static DrawResult of(WinningLotto winningLotto, BonusNumber bonusNumber, LottoTicket lottoTicket) {
        return new DrawResult(winningLotto, bonusNumber, lottoTicket);
    }
    // 직접 Map을 초기화 해주는 이유는 당첨 되지 않은 등수도 0개라는 카운트를 명시적으로 가지게 하기 위함.
    private void initDrawResult() {
        Prize[] prizes = values();
        Arrays.stream(prizes).forEach(
                prize -> { drawResult.put(prize, INIT_COUNT); }
        );
    }

    public void generateDrawResult() {
        List<Lotto> ticket = lottoTicket.lottoTicket();
        for (Lotto lotto : ticket) {
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
        Integer currentWinningCount = drawResult.getOrDefault(prize, INIT_COUNT);
        drawResult.put(prize, currentWinningCount + 1);
    }

    public Map<Prize, Integer> getDrawResult() {
        return drawResult;
    }
    // 추첨 결과를 기반으로 티켓 당 총 상금을 계산
    // 메서드 명을 calculateTotalPrizeMoney로 변경해서 직접 계산해서 반환한다는 행위를 좀 더 명시해보자
    // 안의 변수도 sum보다는 totalMoney로 작성해보자
    public int getTotalPrizeMoney() {
        int sum = 0;
        Set<Prize> prizes = drawResult.keySet();
        for (Prize prize : prizes) {
            sum += prize.sumPrizeMoney(drawResult.get(prize));
        }
        return sum;
    }

}
