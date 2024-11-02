package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        int[] num = new int[46] ;
        Arrays.fill(num, 0);
        for (int i = 0; i < numbers.size(); i++) {
            int idx = Integer.parseInt(numbers.get(i).toString());
            num[idx]++;
            if (num[idx] > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호 중복되지 않는 수이여야 합니다.");
            }
        }
    }
}
