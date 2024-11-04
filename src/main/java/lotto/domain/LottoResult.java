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
        sb.append("3개 일치 (5,000원) - ").append(prizeIntegerMap.getOrDefault(LottoPrize.FIFTH, 0)).append("개").append("\n");
        sb.append("4개 일치 (50,000원) - ").append(prizeIntegerMap.getOrDefault(LottoPrize.FOURTH, 0)).append("개").append("\n");
        sb.append("5개 일치 (1,500,000원) - ").append(prizeIntegerMap.getOrDefault(LottoPrize.THIRD, 0)).append("개").append("\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(prizeIntegerMap.getOrDefault(LottoPrize.SECOND, 0)).append("개").append("\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(prizeIntegerMap.getOrDefault(LottoPrize.FIRST, 0)).append("개").append("\n");
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
