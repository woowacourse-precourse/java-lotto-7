package lotto.dto;

public class WinningNumbersStatics {
    private final int matchNumbers;

    public WinningNumbersStatics(int inputMatchNumbers) {
        matchNumbers = inputMatchNumbers;
    }
    public int getMatchNumbers() {
        return matchNumbers;
    }
}
