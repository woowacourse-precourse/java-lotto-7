package lotto.core.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.core.constants.Error;
import lotto.core.constants.Error.LottoError;
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
        if (numbers.size() != LottoRule.LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBERS_LENGTH);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoRule.LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER_DUPLICATED);
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        boolean anyNotLottoNumber = numbers.stream().anyMatch(it -> !LottoNumber.isNumber(it));
        if (anyNotLottoNumber) {
            throw new IllegalArgumentException(Error.LottoNumber.INVALID_NUMBER_RANGE);
        }
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
        int startInclusive = LottoRule.LOTTO_NUM_MIN_VALUE;
        int endInclusive = LottoRule.LOTTO_NUM_MAX_VALUE;
        int count = LottoRule.LOTTO_NUMBERS_LENGTH;
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return new Lotto(numbers);
    }
}
