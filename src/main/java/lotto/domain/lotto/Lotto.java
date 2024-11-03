package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.dto.LottoNumberDto;
import lotto.exception.lotto.InvalidLottoException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new ArrayList<>(mapToSortedLottoNumber(numbers));
    }

    public static List<Lotto> makeAsMuchAs(BigDecimal quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (BigDecimal count = BigDecimal.ZERO; count.compareTo(quantity) < 0; count = count.add(BigDecimal.ONE)) {
            lottos.add(new Lotto(drawLotto()));
        }
        return lottos;
    }

    private static List<Integer> drawLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
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

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
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
                .map(LottoNumber::valueOf)
                .toList();
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
