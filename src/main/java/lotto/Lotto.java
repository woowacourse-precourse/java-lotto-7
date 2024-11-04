package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Vaildator.InputValidator;
import lotto.Vaildator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateAndSort(numbers);
    }

    private List<Integer> validateAndSort(List<Integer> numbers) {
        InputValidator.emptyContain(numbers);
        LottoValidator.valid(numbers);
        return sortNumbers(new ArrayList<>(numbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers; // 번호 반환
    }

    public String toString() {
        return numbers.toString(); // 번호 출력
    }
}