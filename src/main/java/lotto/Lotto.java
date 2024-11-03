package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)); // 불변 리스트를 변경 가능 리스트로 복사
            Collections.sort(numbers); // 오름차순 정렬
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
