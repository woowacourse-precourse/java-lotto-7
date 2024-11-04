package lotto.domains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Set<Integer> unduplicatedNumbers = new HashSet<>(numbers);
        validate(unduplicatedNumbers);
        this.numbers = new ArrayList<>(unduplicatedNumbers);
    }

    private void validate(Set<Integer> numbers) {
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
