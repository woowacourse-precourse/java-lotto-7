package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    // <당첨 결과, 해당 결과의 누적 개수>
    private final Map<WinningRank, Integer> results = new EnumMap<>(WinningRank.class);

    // 결과를 기록하는 메소드
    public void record(WinningRank rankInfo) {
        // getOrDefault를 사용하여 rankInfo에 매칭되는 것이 없을때, 0 반환
        results.put(rankInfo, results.getOrDefault(rankInfo, 0) + 1);
    }

    // 상금의 총합을 구하는 메소드
    public int totalPrize() {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<WinningRank, Integer> getResults() {
        return results;
    }
}
