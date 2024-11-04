package lotto.controller.dto;

import java.util.List;

public record PrizeResultsDto(
        List<PrizeResultInfo> results
) {
    public PrizeResultsDto(List<PrizeResultInfo> results) {
        this.results = results;
    }
}
