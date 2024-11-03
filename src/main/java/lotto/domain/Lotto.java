package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        StringBuilder lottoNumberString = new StringBuilder("[");
        Iterator <Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            lottoNumberString.append(iterator.next());
            if (iterator.hasNext()) {
                lottoNumberString.append(", ");
            }
        }
        lottoNumberString.append("]");

        return lottoNumberString.toString();
    }
}
