package lotto.dto;

import java.util.List;

public class WinningNumbersDto {

    public List<Integer> value;

    public WinningNumbersDto(List<Integer> numbers) {
        this.value = numbers;
    }
}
