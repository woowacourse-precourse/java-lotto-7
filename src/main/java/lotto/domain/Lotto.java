package lotto.domain;

import static lotto.config.ErrorMessageConstant.DUPLICATED_LOTTO_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.INSUFFICIENT_LOTTO_NUMBERS_MESSAGE;
import static lotto.config.GameConstant.NUMBER_OF_WINNING_NUMBER;

import java.util.HashSet;
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
            throw new IllegalArgumentException(INSUFFICIENT_LOTTO_NUMBERS_MESSAGE);
        }

        if(new HashSet<>(numbers).size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE);
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
