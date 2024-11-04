package lotto.dto;

import java.util.List;
import lotto.model.MatchingCountResult;

public record LottoResult(List<MatchingCountResult> matchingCountResults, double rate) {
}
