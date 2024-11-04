package lotto.dto.response;

import lotto.Rank;

import java.util.Map;

public record LottoResultResponse(Map<Rank, Integer> countResult, String rate) {
}
