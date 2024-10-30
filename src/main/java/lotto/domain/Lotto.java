package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_SIZE;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);

        this.numbers = convertToLottoNumbers(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumber(final List<Integer> numbers) {
        if (isDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 번호가 존재합니다.");
        }
    }

    private List<LottoNumber> convertToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .toList();
    }

    private boolean isDuplicatedNumber(final List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
