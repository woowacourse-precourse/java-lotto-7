package lotto;

import java.util.Collections;
import java.util.List;
import camp.nextstep.*;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers); //오름차순 정렬
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        //1부터 45사이의 숫자 검증
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이의 숫자입니다");
            }

        }
    }

    // TODO: 추가 기능 구현

}
