package lotto.domain;

import lotto.util.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateNewLottoNumber(numbers);
    }

    private List<Integer> Sort(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString(){
        return numbers.toString();
    }
}
