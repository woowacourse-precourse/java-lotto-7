package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final long totalEarning;
    private final InputMoney inputMoney;
    private final Map<LottoPrize,Integer> prizeIntegerMap;

    private LottoResult(List<LottoPrize> result, long totalEarning, InputMoney inputMoney) {
        this.totalEarning = totalEarning;
        this.inputMoney = inputMoney;
        this.prizeIntegerMap = updateMap(result);
    }

    public StringBuilder result(StringBuilder sb) {
        LottoPrize[] prizes = LottoPrize.values();
        for (int i = prizes.length - 1; i >= 0; i--) {
            LottoPrize prize = prizes[i];
            sb.append(prize.getMatchCount())
                    .append("개 일치");
            if (prize.requiresBonus()) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (")
                    .append(String.format("%,d", prize.getPrize()))
                    .append("원) - ")
                    .append(prizeIntegerMap.getOrDefault(prize, 0))
                    .append("개")
                    .append("\n");
        }
        sb.append("총 수익률은 ").append(computeProfitRate()).append("%입니다.");
        return sb;
    }

    private String computeProfitRate() {
        double profitRate = (double) totalEarning / inputMoney.amount() * 100;
        return String.format("%.1f", profitRate); // 첫째 자리만 표시하고 둘째 자리 반올림
    }

    private Map<LottoPrize,Integer> updateMap(List<LottoPrize> result) {
        Map<LottoPrize,Integer> prizeIntegerMap = new HashMap<>();
        for(LottoPrize prize : result) {
            prizeIntegerMap.put(prize,prizeIntegerMap.getOrDefault(prize,0) + 1);
        }
        return prizeIntegerMap;
    }

    public static LottoResult of(List<LottoPrize> result, long totalEarning, InputMoney userInputMoney) {
        return new LottoResult(result, totalEarning, userInputMoney);
    }
}
