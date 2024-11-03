package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateSufficient(numbers);
        LottoValidator.validateDuplicate(numbers);
        LottoValidator.validateValueRange(numbers); // numbers 를 구성하는 num 들이  0로또 번호의 숫자 범위는 1~45까지이다.
    }
    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }



}
