package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoApplicationException;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .toList());
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoApplicationException(String.format("로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_SIZE));
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (isDuplicated(numbers)) {
            throw new LottoApplicationException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicated(List<LottoNumber> numbers) {
        Set<LottoNumber> distinctNumbers = new HashSet<>();
        return !numbers.stream()
                .allMatch(distinctNumbers::add);
    }

}
