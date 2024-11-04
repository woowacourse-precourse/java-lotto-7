package lotto.dto;

public record WinningResultResponse(int firstWinningCount,
                                    int secondWinningCount,
                                    int thirdWinningCount,
                                    int fourthWinningCount,
                                    int fifthWinningCount,
                                    float profitRate) {
}
