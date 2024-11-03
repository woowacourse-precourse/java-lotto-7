package lotto.dto;

import java.util.List;

public class WinningResultsDto {

    private final List<WinningResultDto> results;

    public WinningResultsDto(List<WinningResultDto> results) {
        this.results = results;
    }

    public List<WinningResultDto> getResults() {
        return results;
    }
}
