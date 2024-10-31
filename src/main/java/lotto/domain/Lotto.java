package lotto.domain;

import lotto.constants.message.InputError;
import lotto.constants.message.RangeError;
import lotto.constants.value.LottoRule;
import lotto.domain.factory.LottoFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    //Components 라고 명명하고 싶으나 numbers 명을 바꿔도 되는지 모르겠어서 남겨둡니다.
    private final List<Component> numbers;

    public Lotto(List<Component> components){
        this.numbers = components;
    }

    private Lotto(LottoFactory lottoFactory) {

        this.numbers = lottoFactory.randomCreate();
        validateLength(numbers,lottoFactory.getLottoLength());
        validateDuplicate(numbers);

    }

    public static Lotto from(LottoFactory lottoFactory){
        return new Lotto(lottoFactory);
    };

    //방어적 복사
    public List<Component> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validateLength(List<Component> numbers, int lottoLength) {
        if (numbers.size() != lottoLength) {
            System.out.println(RangeError.LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Component> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            System.out.println(InputError.DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
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
}
