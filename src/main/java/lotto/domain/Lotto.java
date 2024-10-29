package lotto.domain;

import lotto.service.LottoNumGenerator;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUM_COUNT = 6;
    private static final String LOTTO_NUM_DUPLICATED = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(LottoNumGenerator lottoNumGenerator) {
        numbers = generateLottoNumbers(lottoNumGenerator);
        validateNumbers(numbers);
        sortNums();
    }

    private void validateNumbers(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
    }

    private List<Integer> generateLottoNumbers(LottoNumGenerator lottoNumGenerator) {
        return lottoNumGenerator.generateNumbers(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_NUM_COUNT);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATED);
        }
    }

    private void sortNums() {
        numbers.sort(Comparator.naturalOrder());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
