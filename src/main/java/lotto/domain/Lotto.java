package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public record Lotto(List<LottoNumber> numbers) {

    public final static int LOTTO_SIZE = 6;

    public Lotto {
        validate(numbers);
        numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto from(final List<Integer> intNumbers) {
        List<LottoNumber> lottoNumbers = intNumbers.stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int countMatches(final Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validate(final List<LottoNumber> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateLottoSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException("로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new LottoException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
