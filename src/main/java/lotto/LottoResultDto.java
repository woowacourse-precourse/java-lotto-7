package lotto;

import java.util.Map;
import lotto.util.LottoPrizeRankType;

public record LottoResultDto(Map<LottoPrizeRankType, Long> rankLotto, float rateOfReturn) {

}
