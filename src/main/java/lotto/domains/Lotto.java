package lotto.domains;

import java.util.Arrays;
import java.util.Collections;
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

    // TODO: 추가 기능 구현
    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public String getNumbersString() {
        return Arrays.toString(numbers.toArray());
    }

    public boolean existsNumber(int target) {
        return Collections.binarySearch(numbers, target) >= 0;
    }

    public int getCount(Lotto lotto) {
        int count = 0;
        for (Integer num : lotto.numbers) {
            if(existsNumber(num))   count++;
        }

        return count;
    }
}
