package lotto.domain;

import lotto.dto.WinningNumbersDto;

import java.util.List;

public class WinningNumbers {

    private List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static WinningNumbers fromDto(WinningNumbersDto dto) {
        return new WinningNumbers(dto.value);
    }
}
