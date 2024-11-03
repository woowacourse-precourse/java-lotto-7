package lotto.model;

import java.util.Map;
import lotto.constants.PrizeRank;

public record LottoGameResult(Map<PrizeRank, Integer> prizeResultMap, double profitRate) {
}
