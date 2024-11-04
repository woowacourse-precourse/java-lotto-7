package lotto.dto;

import static lotto.model.Winning.NONE;

import java.util.List;
import java.util.Map;

import lotto.model.Winning;

public record WinningResultsDto(
	List<WinningResultDto> winningResults,
	double profitRate
) {

	public static WinningResultsDto from(Map<Winning, Integer> winningResult, double profitRate) {
		return new WinningResultsDto(getWinningResults(winningResult), profitRate);
	}

	private static List<WinningResultDto> getWinningResults(Map<Winning, Integer> winningResult) {
		return winningResult.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.filter(winning -> winning.getKey() != NONE)
				.map(winning -> WinningResultDto.from(winning.getKey(), winning.getValue()))
				.toList();
	}
}
