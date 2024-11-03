package lotto.store.lotto;

import java.util.List;

public class Lotto {
    protected static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if(isInvalidSize(numbers))
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        if(hasDuplicatedNumbers(numbers))
            throw new IllegalArgumentException("로또 번호는 6개는 유니크해야 합니다.");

        this.numbers = numbers.stream().sorted().toList();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean hasSameNumber(Lotto lotto) {
        return countMatchingNumber(lotto) == LOTTO_SIZE;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private boolean isInvalidSize(List<LottoNumber> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasDuplicatedNumbers(List<LottoNumber> numbers) {
        return countUniqueNumber(numbers) != numbers.size();
    }

    private long countUniqueNumber(List<LottoNumber> numbers) {
        return numbers.stream().distinct().count();
    }
}
