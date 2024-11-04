package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoStatus {

    private final List<Integer> numbers;

    public LottoStatus(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
