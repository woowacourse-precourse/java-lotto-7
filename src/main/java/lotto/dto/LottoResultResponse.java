// LottoResultResponse.java
package lotto.dto;

import lotto.model.LottoRanking;

import java.util.Map;

public record LottoResultResponse(Map<LottoRanking, Integer> rankingCount, double profitRate) {
}