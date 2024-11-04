package lotto.lottoMachine;

import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> resultMap;
    private Double profitRatio;

    public LottoResult(Map<LottoRank, Integer> resultMap, Double profitRatio) {
        this.resultMap = resultMap;
        this.profitRatio = profitRatio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<LottoRank, Integer> entry : resultMap.entrySet()) {
            LottoRank lottoRank = entry.getKey();
            sb.append(lottoRank.getDescription()).append(entry.getValue()).append("개 \n");
        }

        sb.append(String.format("총 수익률은 %.1f%%입니다.\n", profitRatio));
        return sb.toString();
    }
}
