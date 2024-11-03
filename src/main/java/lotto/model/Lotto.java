package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::getValue))
                .collect(Collectors.toList());
    }

    public static Lotto from(String numbers) {
        return new Lotto(
                Arrays.stream(numbers.split(","))
                        .map(LottoNumber::from)
                        .collect(Collectors.toList()));
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static List<LottoNumber> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int calcMatchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
