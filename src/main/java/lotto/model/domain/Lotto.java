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
                        .sorted()
                        .map(String::valueOf)
                        .toList()
        ) + "]";
    }

    protected List<Integer> getNumbers() {
        return lottoNumbers.getNumbers();
    }

    public int countDuplicatingCount(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.countDuplicatingNumbers(lottoNumbers);
    }

    public int countDuplicatingCount(LottoNumber LottoNumber) {
        if(lottoNumbers.hasNumber(LottoNumber)) {
            return 1;
        }
        return 0;
    }
}
