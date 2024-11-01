package lotto.model.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.getNumbers().contains(number);
    }

    @Override
    public String toString() {
        return "[" + String.join(", ",
                lottoNumbers.getNumbers().stream()
                        .map(String::valueOf)
                        .toList()
        ) + "]";
    }

    protected List<Integer> getNumbers() {
        return lottoNumbers.getNumbers();
    }
}
