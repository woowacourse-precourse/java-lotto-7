package lotto.model;

import java.util.List;
import java.util.Map;

public record WinningResultsDto(
	List<WinningResultDto> winningResults
) {

	public static WinningResultsDto from(Map<Winning, Integer> winningResult) {
		return new WinningResultsDto(getWinningResults(winningResult));
	}

	private static List<WinningResultDto> getWinningResults(Map<Winning, Integer> winningResult) {
		return winningResult.entrySet().stream()
				.map(winning -> WinningResultDto.from(winning.getKey(), winning.getValue()))
				.toList();
	}
}
