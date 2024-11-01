package lotto.domain;

import lotto.constants.string.InputError;
import lotto.constants.string.RangeError;
import lotto.constants.value.LottoRule;
import lotto.domain.factory.LottoFactory;

import java.util.*;

public class Lotto {

    //Components 라고 명명하고 싶으나 numbers 명을 바꿔도 되는지 모르겠어서 남겨둡니다.
    private final List<Component> numbers;

    public Lotto(List<Component> components) {
        validateLength(components);
        validateDuplicate(components);
        this.numbers = components;
    }

    private Lotto(LottoFactory lottoFactory) {

        this.numbers = lottoFactory.randomCreate();
        validateLength(numbers);
        validateDuplicate(numbers);

    }

    public static Lotto from(LottoFactory lottoFactory) {
        return new Lotto(lottoFactory);
    }


    public List<Component> getComponents() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateLength(List<Component> numbers) {
        if (numbers.size() != LottoRule.COMBINATION_LENGTH.getInstance()) {
            throw new IllegalArgumentException(RangeError.LOTTO_LENGTH.getInstance());
        }
    }

    private void validateDuplicate(List<Component> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(InputError.DUPLICATE_LOTTO_NUMBER.getInstance());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
