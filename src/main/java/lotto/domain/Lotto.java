package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.exception.InvalidLottoException;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        List<Integer> sortedNumbers = sort(numbers);
        validateNumber(sortedNumbers);
        this.numbers = new ArrayList<>(sortedNumbers);
    }

    public Lotto(final NumberGenerator<Integer> generator) {
        this(generator.generateNumbers());
    }

    public static List<Lotto> createAsMuchAs(final Quantity quantity, final NumberGenerator generator) {
        BigDecimal purchaseQuantity = quantity.getQuantity();
        List<Lotto> lottos = new ArrayList<>();
        for (BigDecimal count = BigDecimal.ZERO; count.compareTo(purchaseQuantity) < 0;
             count = count.add(BigDecimal.ONE)) {
            lottos.add(new Lotto(generator));
        }
        return lottos;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber.getNumber());
    }

    public int countMatchingNumber(final Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(number -> winningLotto.contains(new LottoNumber(number)))
                .count();
    }

    public boolean doesMatchBonusNumber(final LottoNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == bonusNumber.getNumber());
    }

    private List<Integer> sort(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validateNumber(final List<Integer> numbers) {
        if (countUniqueFrom(numbers) != LOTTO_SIZE) {
            throw new InvalidLottoException("로또 번호는 중복되지 않은 6개의 숫자여야 합니다");
        }
        if (isOutOfRange(numbers)) {
            throw new InvalidLottoException("로또 번호는 1 이상 45 이하여야 합니다");
        }
    }

    private long countUniqueFrom(final List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

    private boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number < 1 || number > 45));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
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
