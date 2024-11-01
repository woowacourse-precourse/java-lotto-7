package lotto.model.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
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

    public int countDuplicatingCount(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.countDuplicatingNumbers(lottoNumbers.getNumbers());
    }

    public int countDuplicatingCount(int number) {
        if(lottoNumbers.hasNumber(number)) {
            return 1;
        }
        return 0;
    }
}
