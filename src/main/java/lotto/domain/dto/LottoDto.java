package lotto.domain.dto;

import java.util.Collections;
import java.util.List;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
