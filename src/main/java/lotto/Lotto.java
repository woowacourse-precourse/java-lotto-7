package lotto;

import java.util.List;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void printNums() {
        int i = 0;
        for(Integer number : numbers) {
            if(i == 0) {
                System.out.print("[");
                System.out.print(number);
                i++;
                continue;
            }
            System.out.print(", " + number);

            if(i == 5) {
                System.out.println("]");
            }
            i++;
        }
    }
}
