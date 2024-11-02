package lotto.model.outcome;

import lotto.model.PrizeGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<String> result;
    
    private LottoResult(List<String> result) {
        this.result = result;
    }
    
    public static LottoResult getOfCountGradeAndBenefitRate(CountByPrizeGrade countByGrade,
                                                            LottoBenefitRate rate) {
        List<String> strings = new ArrayList<>();
        strings.add("당첨 통계");
        strings.add("---");

        for (Map.Entry<PrizeGrade, Integer> gradeByCount : countByGrade.getEntrySet()) {
            PrizeGrade grade = gradeByCount.getKey();
            int count = gradeByCount.getValue();
            strings.add(grade + " - " + count + "개");
        }

        strings.add("");
        strings.add("총 수익률은 " + rate + "%입니다.");

        return new LottoResult(strings);
    }

    @Override
    public String toString() {
        return String.join("\n", result);
    }
    
}
