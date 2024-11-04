package lotto.dto;

import lotto.model.match.MatchInformation;

public record MatchDto(MatchInformation matchInformation, int count) {
}
