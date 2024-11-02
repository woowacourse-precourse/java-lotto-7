package lotto.core.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.core.dto.LottoDto;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public static Lotto dtoOf(LottoDto dto) {
        return new Lotto(dto.numbers());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateDuplicated(numbers);
        validateLottoNumber(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        numbers.forEach(LottoNumber::new);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMatchCount(Lotto other) {
        List<Integer> matchNumbers = new ArrayList<>(this.numbers);
        matchNumbers.retainAll(other.numbers);
        return matchNumbers.size();
    }

    public boolean containsBonusNumber(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.value());
    }
}
