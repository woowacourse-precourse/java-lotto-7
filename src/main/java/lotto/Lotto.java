package lotto;

import java.util.Arrays;
import java.util.Comparator;
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

    public String getLottoNumbers() {
        return formatLottoNumber() + "\n";
    }

    private String formatLottoNumber() {
        sortLottoNumbers();
        return String.join(", ", Arrays.toString(numbers.toArray()));
    }

    private void sortLottoNumbers() {
        numbers.sort(Comparator.naturalOrder());
    }

}
