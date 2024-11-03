package lotto.model.outcome;

import lotto.model.BoughtLottos;
import lotto.model.Lotto;
import lotto.model.PrizeGrade;
import lotto.model.winlotto.WinLotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** 로또 등급별 당첨 개수를 구해서 저장하는 클래스 */
public class CountByPrizeGrade {

    private final LinkedHashMap<PrizeGrade, Integer> countByPrizeGrade;

    private CountByPrizeGrade(LinkedHashMap<PrizeGrade, Integer> countByPrizeGrade) {
        this.countByPrizeGrade = countByPrizeGrade;
    }

    // 구매 로또와 우승 번호를 바탕으로 당첨 등급별 개수를 구해서 저장
    public static CountByPrizeGrade getOfBoughtAndWinLotto(BoughtLottos lottos,
                                                           WinLotto winLotto) {
        LinkedHashMap<PrizeGrade, Integer> countByPrizeGrades = new LinkedHashMap<>();
        for (PrizeGrade grade : PrizeGrade.values()) {
            countByPrizeGrades.put(grade, 0);
        }
        for (Lotto lotto : lottos) {
            int matchCount = winLotto.getMatchCount(lotto);
            boolean isBonusMatch = winLotto.getBonusMatch(lotto);
            PrizeGrade grade = PrizeGrade.get(matchCount, isBonusMatch);
            if (grade != null) {
                countByPrizeGrades.put(grade, countByPrizeGrades.getOrDefault(grade, 0) + 1);
            }
        }
        return new CountByPrizeGrade(countByPrizeGrades);
    }

    public Iterable<? extends Map.Entry<PrizeGrade, Integer>> getEntrySet() {
        return Collections.unmodifiableMap(countByPrizeGrade).entrySet();
    }

}
