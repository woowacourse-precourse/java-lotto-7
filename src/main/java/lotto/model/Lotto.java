package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.CustomLottoException;
import lotto.exception.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new CustomLottoException(ErrorMessage.NOT_LOTTO_SIZE);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new CustomLottoException(ErrorMessage.DUPLICATE_VALUES);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new CustomLottoException(ErrorMessage.NOT_NUMBER_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto generateRandomLotto() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numberList);
    }
}
