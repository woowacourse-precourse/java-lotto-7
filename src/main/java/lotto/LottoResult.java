package lotto;

import java.util.List;

public record LottoResult(List<MatchingCountResult> matchingCountResults, int rate) {
}
