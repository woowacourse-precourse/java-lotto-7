package lotto.service;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.dto.LottoResult;

public class CalculateService {

    public BigDecimal calculateRatio(int amount, Map<LottoResult, Integer> drawResult) {
        BigDecimal ratio = BigDecimal.valueOf(calculatePrize(drawResult))
                .divide(BigDecimal.valueOf(amount))
                .multiply(BigDecimal.valueOf(100))
                .stripTrailingZeros(); // 뒤에 불필요한 0 제거
        return new BigDecimal(ratio.toPlainString()); // 일반 숫자 형식으로 변환
    }

    private int calculatePrize(Map<LottoResult, Integer> drawResult) {
        int sum = 0;
        for (LottoResult lottoResult : drawResult.keySet()) {
            int matchingNumberCount = lottoResult.getMatchingNumberCount();
            sum = getSum(lottoResult, drawResult.get(lottoResult), matchingNumberCount, sum);
        }
        return sum;
    }

    private int getSum(LottoResult lottoResult, int count, int matchingNumberCount, int sum) {
        if (matchingNumberCount==5) {
            return calculateFive(lottoResult, count, sum);
        }
        return calculateOthers(lottoResult, sum);
    }

    private static int calculateOthers(LottoResult lottoResult, int sum) {
        if (lottoResult.isBonusMatch()) {
            sum += MatchPrize.getPrizeByMatchCount(lottoResult.getMatchingNumberCount() + 1);
            return sum;
        }
        sum += MatchPrize.getPrizeByMatchCount(lottoResult.getMatchingNumberCount());
        return sum;
    }

    private static int calculateFive(LottoResult lottoResult, int count, int sum) {
        if (lottoResult.isBonusMatch()) {
            sum += (MatchPrize.FIVE_MATCH_WITH_BONUS.getPrize() * count);
            return sum;
        }
        sum += (MatchPrize.FIVE_MATCH.getPrize() * count);
        return sum;
    }


}

