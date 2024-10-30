package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);

        this.numbers = convertToLottoNumbers(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<LottoNumber> convertToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
