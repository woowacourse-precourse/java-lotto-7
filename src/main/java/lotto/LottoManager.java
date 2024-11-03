package lotto;

import lotto.domain.Attempt;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;

import java.util.*;

public class LottoManager {
    private final Attempt attempt;
    private final Lotto lotto;
    private final BonusLotto bonusLotto;
    private final List<Lotto> randomLottoList;

    public LottoManager(Attempt attempt, Lotto lotto, BonusLotto bonusLotto,List<Lotto> randomLottoList) {
        this.attempt = attempt;
        this.lotto = lotto;
        this.bonusLotto = bonusLotto;
        this.randomLottoList = randomLottoList;
    }

    public Map<LottoPrize, Integer> doLotto() {
        //기본 로또 당첨 비교
        Map<LottoPrize, Integer> lottoPrizeMap = initializePrizeMap();

        for(Lotto randomLotto: randomLottoList) {
            int result = lotto.compareLottoNumber(randomLotto.getNumbers());
            updatePrizeMap(lottoPrizeMap, result);
        }
        return lottoPrizeMap;
    }

    private void updatePrizeMap(Map<LottoPrize, Integer> prizeMap, int result) {
        if (result == 6) {
            incrementPrizeCount(prizeMap, LottoPrize.SIX_MATCH);
            return;
        }
        if (result == 5) {
            if (isBonusMatched()) {
                incrementPrizeCount(prizeMap, LottoPrize.FIVE_MATCH_BONUS);
                return;
            }
            incrementPrizeCount(prizeMap, LottoPrize.FIVE_MATCH);
            return;
        }
        if (result == 4) {
            incrementPrizeCount(prizeMap, LottoPrize.FOUR_MATCH);
            return;
        }
        if (result == 3) {
            incrementPrizeCount(prizeMap, LottoPrize.THREE_MATCH);
        }
    }

    private boolean isBonusMatched() {
        return lotto.compareLottoNumber(List.of(bonusLotto.getNumber())) == 1;
    }

    private void incrementPrizeCount(Map<LottoPrize, Integer> prizeMap, LottoPrize prize) {
        prizeMap.put(prize, prizeMap.get(prize) + 1);
    }

    private Map<LottoPrize, Integer> initializePrizeMap() {
        //출력 순서 보장을 위해 HashMap이 아닌 LinkedHashMap을 사용
        Map<LottoPrize, Integer> prizeMap = new LinkedHashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeMap.put(prize, 0));
        return prizeMap;
    }

    /**
     * 수익룰 = (총 수익 - 투자 비용) / 투자 비용 * 100
     */
    public double getROI(Map<LottoPrize, Integer> prizeMap) {
        int usedCash = attempt.getCashAmount();
        int totalPrize = prizeMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getPrize() * entry.getValue())
                .reduce(0, Integer::sum);

        return (double) (totalPrize - usedCash) / usedCash * 100.0;
    }

    public int getLottoAmount() {
        return attempt.getLottoAmount();
    }

    public List<Lotto> getRandomLottoList() {
        return randomLottoList;
    }
}
