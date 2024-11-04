package lotto.dto;

import java.util.List;

public record MatchResponse(List<MatchDto> matchDtos, double rateOfReturn) {
}
