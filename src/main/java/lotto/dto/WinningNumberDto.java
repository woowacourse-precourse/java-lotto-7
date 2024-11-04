package lotto.dto;

import java.util.List;

public record WinningNumberDto(List<Integer> winningNumbers) {
    private static WinningNumberDto winningNumberDto;

    public WinningNumberDto {
        winningNumberDto = new WinningNumberDto(winningNumbers);
    }

    public record BonusNumberDto(int bonusNumber) {
        private static BonusNumberDto bonusNumberDto;

        public BonusNumberDto {
            bonusNumberDto = new BonusNumberDto(bonusNumber);
        }
    }
}
