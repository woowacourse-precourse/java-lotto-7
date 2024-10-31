package lotto.dto;

import lotto.domain.WinningNumbers;

import java.util.List;

public class WinningNumbersDto {

    public List<Integer> value;

    public WinningNumbersDto(List<Integer> numbers) {
        this.value = numbers;
    }

    public static WinningNumbersDto fromEntity(final WinningNumbers winningNumbers) {
        return new WinningNumbersDto(winningNumbers.getNumbers());
    }
}
