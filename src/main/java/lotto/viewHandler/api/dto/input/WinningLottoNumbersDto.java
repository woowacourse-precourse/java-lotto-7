package lotto.viewHandler.api.dto.input;

import java.util.List;

public class WinningLottoNumbersDto {
    private final List<Integer> numbers;

    public WinningLottoNumbersDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }
}
