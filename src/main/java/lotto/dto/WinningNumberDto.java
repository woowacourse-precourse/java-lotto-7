package lotto.dto;

import java.util.List;

public class WinningNumberDto {
    private static List<Integer> winningNumbers;

    public static void set(List<Integer> winningNumbers) {
        WinningNumberDto.winningNumbers = winningNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
