package lotto.dto;

import java.util.List;

public class LottoTicketsDto {
    private final List<Integer> numbers;

    public LottoTicketsDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}