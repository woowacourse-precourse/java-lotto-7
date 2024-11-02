package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRange(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int idx = Integer.parseInt(numbers.get(i).toString());
            if (idx < 1 || idx > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45입니다.");
            }
        }
    }

    private void duplicate(List<Integer> numbers) {
        int[] num = new int[46] ;
        Arrays.fill(num, 0);
        for (int i = 0; i < numbers.size(); i++) {
            int idx = Integer.parseInt(numbers.get(i).toString());
            num[idx]++;
            if (num[idx] > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 수여야 합니다.");
            }
        }
    }

    public void printLottoCount(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
        }
        System.out.println(cost/1000 + "개를 구매했습니다.");
    }
}
