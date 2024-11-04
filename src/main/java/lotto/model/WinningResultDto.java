package lotto.model;

public record WinningResultDto(
	int matchCount,
	long prize,
	int winningCount
) {
}
