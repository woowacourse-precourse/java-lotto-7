package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.quantity.Quantity;
import lotto.dto.LottoNumberDto;
import lotto.exception.argument.lotto.InvalidLottoException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateUnique(numbers);
        this.numbers = new ArrayList<>(toSortedLottoNumbers(numbers));
    }

    public static List<Lotto> createMultipleLottos(Quantity quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (BigDecimal count = BigDecimal.ZERO; count.compareTo(quantity.getQuantity()) < 0; count = count.add(BigDecimal.ONE)) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomLottoNumbers() {
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

    private void validateUnique(final List<Integer> numbers) {
        if (countUniqueFrom(numbers) != LOTTO_SIZE) {
            throw new InvalidLottoException("로또는 중복되지 않은 6개의 숫자여야 합니다.");
        }
    }

    private long countUniqueFrom(final List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

    private List<LottoNumber> toSortedLottoNumbers(final List<Integer> numbers) {
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
