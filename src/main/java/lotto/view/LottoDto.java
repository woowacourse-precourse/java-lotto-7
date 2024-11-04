package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto createLottoDto(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }
}
