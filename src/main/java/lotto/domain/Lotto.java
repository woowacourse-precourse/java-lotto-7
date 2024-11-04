package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        // 불변 리스트를 수정 가능한 리스트로 복사하여 정렬 가능하도록 합니다.
        this.numbers = new ArrayList<>(numbers);
        sortLottoNumbers();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers); // 불변 리스트로 반환하여 외부 수정 방지
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < Constants.LOTTO_MIN_NUM || number > Constants.LOTTO_MAX_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이어야 합니다.");
            }
        }
    }

    private void sortLottoNumbers() {
        Collections.sort(this.numbers); // 수정 가능한 리스트로 정렬 가능
    }
}
