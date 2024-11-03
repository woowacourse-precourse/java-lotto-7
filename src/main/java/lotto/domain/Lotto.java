package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public Lotto(String invalidNumbers) {
        this(Arrays.stream(invalidNumbers.split(","))
                .map(Integer::parseInt)
                .toList());
    }

    public int getEqualCount(Lotto otherLotto) {
        List<Integer> otherLottoNumbers = new ArrayList<>(otherLotto.getNumbers());
        otherLottoNumbers.retainAll(numbers);

        return otherLottoNumbers.size();
    }

    public boolean isExist(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
