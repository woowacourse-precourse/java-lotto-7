package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRange(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }

    // 1~45 사이의 숫자인지 체크한다
    private void checkRange(List<Integer> numbers) {
            for(int tmp : numbers) {
            if(tmp < 1 || tmp > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }
}
