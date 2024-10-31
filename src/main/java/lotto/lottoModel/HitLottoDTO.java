package lotto.lottoModel;

import java.util.List;

public class HitLottoDTO {
    private List<Integer> numbers;

    public HitLottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
