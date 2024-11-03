package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.exception.InvalidLottoException;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new ArrayList<>(mapToSortedLottoNumber(numbers));
    }

    public static List<Lotto> makeAsMuchAs(List<List<? extends Number>> numbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<? extends Number> list : numbers) {
            lottos.add(new Lotto((List<Integer>) list));
        }
        return lottos;
    }

    public int countMatchingNumber(final Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean doesMatchBonusNumber(final LottoNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    private void validateNumbers(final List<Integer> numbers) {
        if (countDistinctFrom(numbers) != LOTTO_SIZE) {
            throw new InvalidLottoException("로또 번호는 중복되지 않은 6개의 숫자여야 합니다");
        }
    }

    private long countDistinctFrom(final List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

    private List<LottoNumber> mapToSortedLottoNumber(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public LottoNumberDto getNumbers() {
        return LottoNumberDto.of(numbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto other = (Lotto) o;
        return Objects.equals(numbers, other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
