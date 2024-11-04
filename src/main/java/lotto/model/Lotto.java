package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.exceptions.ArgumentException;

public class Lotto {
    public static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<LottoNumber> numbers) throws ArgumentException {
        if (numbers.size() != SIZE) {
            throw ArgumentException.INVALID_LOTTO_SIZE;
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(final List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != SIZE) {
            throw ArgumentException.DUPLICATE_LOTTO_NUMBER;
        }
    }

    public static Lotto from(final List<Integer> numbers) {
        return new Lotto(LottoNumber.valueOf(numbers));
    }

    public static Lotto createAutoLotto() {
        return from(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE, SIZE));
    }

    public static Lotto createManualLotto(final List<Integer> numbers) throws ArgumentException {
        return from(numbers);
    }

    boolean has(final int bonusBall) {
        return this.numbers.contains(bonusBall);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean equalTo(Lotto other) {
        for (LottoNumber o : other.getNumbers()) {
            return numbers.stream()
                    .allMatch(number -> number.compareTo(o) == 0);
        }
        return false;
    }

}
