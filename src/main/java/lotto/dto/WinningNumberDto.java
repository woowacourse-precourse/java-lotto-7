package lotto.dto;

import java.util.List;

public record WinningNumberDto(
        List<Integer> winningNumbers
) {
    private static WinningNumberDto winningNumberDto;

    public WinningNumberDto {
        winningNumberDto = new WinningNumberDto(winningNumbers);
    }

    public static WinningNumberDto getWinningNumberDto() {
        return winningNumberDto;
    }
}
