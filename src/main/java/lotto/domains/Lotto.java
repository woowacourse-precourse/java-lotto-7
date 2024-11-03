package lotto.domains;

import java.util.Arrays;
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

    private int[] getSortedNumbers() {
        int[] numbers = this.numbers.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(numbers);

        return numbers;
    }

    public String getNumbersString() {
        return Arrays.toString(getSortedNumbers());
    }

    public boolean existsNumber(int target) {
        return Arrays.binarySearch(getSortedNumbers(), target) >= 0;
    }

    public int getCount(Lotto lotto) {
        int count = 0;
        for (Integer num : lotto.numbers) {
            if(existsNumber(num))   count++;
        }

        return count;
    }
}
