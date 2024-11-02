package lotto.ui.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersResponse {

    private final List<Integer> numbers;

    private LottoNumbersResponse(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbersResponse from(List<Integer> numbers) {
        return new LottoNumbersResponse(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
