package lotto.service;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.dto.LottoResult;

public class CalculateService {

    // 수익률 계산
    public BigDecimal calculateRatio(int amount, Map<LottoResult, Integer> drawResult){
        BigDecimal ratio = BigDecimal.valueOf(calculatePrize(drawResult))
                .divide(BigDecimal.valueOf(amount))
                .multiply(BigDecimal.valueOf(100))
                .stripTrailingZeros(); // 뒤에 불필요한 0 제거
        return new BigDecimal(ratio.toPlainString()); // 일반 숫자 형식으로 변환
    }

    // 당첨금액 계산
    private int calculatePrize(Map<LottoResult, Integer> drawResult){
        int sum = 0;
        for (LottoResult lottoResult: drawResult.keySet()){
            int matchingNumberCount = lottoResult.getMatchingNumberCount();
            if (matchingNumberCount == 5 && lottoResult.isBonusMatch()){
                sum += MatchPrize.FIVE_MATCH_WITH_BONUS.getPrize();
            }
            sum += MatchPrize.getPrizeByMatchCount(lottoResult.getMatchingNumberCount());
        }
        return sum;
    }


}

