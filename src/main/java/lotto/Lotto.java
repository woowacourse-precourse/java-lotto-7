package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static lotto.LottoConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        boolean isUnique = numbers.stream().distinct().count() == numbers.size();
        if (!isUnique) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        int minLottoNumber = MIN_NUMBER.getValue();
        int maxLottoNumber = MAX_NUMBER.getValue();
        boolean isValidRange = numbers.stream()
                .allMatch(number -> number >= minLottoNumber && number <= maxLottoNumber);
        if (!isValidRange) {
            throw new IllegalArgumentException("[ERROR] " + minLottoNumber + " - " + maxLottoNumber + "사이의 수를 입력하세요");
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public List<Integer> getSortedLottoNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(getLottoNumbers());
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
