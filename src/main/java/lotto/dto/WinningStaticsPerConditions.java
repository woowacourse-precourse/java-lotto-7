package lotto.dto;

public class WinningStaticsPerConditions {
    private final int matchNumbers;

    public WinningStaticsPerConditions(int inputMatchNumbers) {
        matchNumbers = inputMatchNumbers;
    }
    public int getMatchNumbers() {
        return matchNumbers;
    }
}
