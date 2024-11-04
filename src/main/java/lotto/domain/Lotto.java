package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // 가변 리스트로 복사
        List<Integer> mutableNumbers = new ArrayList<>(numbers);

        // 검증 작업 수행
        validate(mutableNumbers);
        validateNoDuplicates(mutableNumbers);
        validateLottoNumberRange(mutableNumbers);

        // 정렬 후 불변 리스트로 설정
        Collections.sort(mutableNumbers);
        this.numbers = Collections.unmodifiableList(mutableNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        ConcurrentHashMap<Integer, Boolean> uniqueValues = new ConcurrentHashMap<>();

        for (Integer number : numbers) {
            if (uniqueValues.putIfAbsent(number, true) != null) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
