package lotto.model;

import java.util.List;

public record WinningResultsDto(
	List<WinningResultDto> winningResults
) {
}
