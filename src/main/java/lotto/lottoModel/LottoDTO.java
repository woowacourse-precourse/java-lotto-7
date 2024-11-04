package lotto.lottoModel;

import java.util.List;

public class LottoDTO {
    private List<Integer> numbers;

    public LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}