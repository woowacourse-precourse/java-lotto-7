package lotto.dto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoResult;

public record LottoResultDto(
        Map<LottoResult, Integer> result,
        double profitRate
) {
    // LottoResult 타입이 없는 경우 0으로 초기화
    // 이익률 계산
    public static LottoResultDto of(Map<LottoResult, Integer> result, int money) {
        Map<LottoResult, Integer> totalResult = new EnumMap<>(LottoResult.class);
        List<LottoResult> list = Arrays.stream(LottoResult.values())
                .filter(lottoResult -> !lottoResult.equals(LottoResult.NONE))
                .toList();
        double sum = 0;
        for (LottoResult lottoResult : list) {
            totalResult.put(lottoResult, result.getOrDefault(lottoResult, 0));
            sum += totalResult.get(lottoResult) * lottoResult.getRewardAmount();
        }
        double profitRate = sum * 100 / money;
        return new LottoResultDto(totalResult, profitRate);
    }
}
