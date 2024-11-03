package lotto.core.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.core.constants.Error;
import lotto.core.dto.LottoDto;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto dtoOf(LottoDto dto) {
        return new Lotto(dto.numbers());
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicated(numbers);
        validateLottoNumber(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.Lotto.INVALID_NUMBERS_LENGTH);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(Error.Lotto.INVALID_NUMBER_DUPLICATED);
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        numbers.forEach(LottoNumber::new);
    }

    public List<Integer> getNumbers() {
        return this.numbers.stream().sorted().toList();
    }

    public int getMatchCount(Lotto other) {
        List<Integer> matchNumbers = new ArrayList<>(this.numbers);
        matchNumbers.retainAll(other.numbers);
        return matchNumbers.size();
    }

    public boolean containsBonusNumber(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.value());
    }

    public static Lotto newRandomNumbers() {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
