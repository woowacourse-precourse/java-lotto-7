package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<String> result;
    
    private LottoResult(List<String> result) {
        this.result = result;
    }
    
    public static LottoResult getInstance(WinLotto winLotto, BoughtLottos lottos) {
        List<String> strings = new ArrayList<>();
        LinkedHashMap<PrizeGrade, Integer> countByPrizeGrades =
                getCountByPrizeGrade(winLotto, lottos);
        addCountByPrizeGrade(strings, countByPrizeGrades);
        BigDecimal benefitRate = getRate(countByPrizeGrades, lottos.getSpendMoney());
        strings.add("총 수익률은 " + benefitRate + "%입니다.");
        return new LottoResult(strings);
    }
    
    private static LinkedHashMap<PrizeGrade, Integer> getCountByPrizeGrade(WinLotto winLotto,
                                                                           BoughtLottos lottos) {
        
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
        return countByPrizeGrades;
    }

    private static void addCountByPrizeGrade(List<String> strings,
                                             LinkedHashMap<PrizeGrade, Integer> countByGrades) {
        strings.add("당첨 통계");
        strings.add("---");
        for (Map.Entry<PrizeGrade, Integer> gradeByCount : countByGrades.entrySet()) {
            PrizeGrade grade = gradeByCount.getKey();
            int count = gradeByCount.getValue();
            strings.add(grade + " - " + count + "개");
        }
    }
    
    private static BigDecimal getRate(LinkedHashMap<PrizeGrade, Integer> countByGrades,
                                      long spendMoney) {
        long totalPrizeMoney = 0L;
        for (Map.Entry<PrizeGrade, Integer> gradeByCount : countByGrades.entrySet()) {
            PrizeGrade grade = gradeByCount.getKey();
            int count = gradeByCount.getValue();
            totalPrizeMoney += grade.getMoney() * count;
        }
        
        BigDecimal prizeMoneySum = BigDecimal.valueOf(totalPrizeMoney);
        BigDecimal spendMoneyBD = BigDecimal.valueOf(spendMoney);
        BigDecimal hundred = BigDecimal.valueOf(100);
        prizeMoneySum = prizeMoneySum.multiply(hundred);
        return prizeMoneySum.divide(spendMoneyBD, 1, RoundingMode.HALF_UP);
    }
    
    
    @Override
    public String toString() {
        return String.join("\n", result);
    }
    
}
