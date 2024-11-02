package lotto.domain.lottoForm;

import java.util.List;

public class Lotto extends LottoForm {
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateAndSort(numbers);
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
