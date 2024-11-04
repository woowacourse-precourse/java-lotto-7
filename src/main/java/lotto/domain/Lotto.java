package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 로또번호는 중복될 수 없습니다.";

    private final List<LottoNumber> numbers;

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(convertToLottoNumbers(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        validateDuplicated(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validateDuplicated(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int calculateMatchCount(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::hasNumber)
                .count();
    }
}
