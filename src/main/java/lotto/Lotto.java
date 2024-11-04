package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    // 제공된 Lotto 클래스를 사용하여 구현해야 한다.
    // 필드(인스턴스 변수)를 추가할 수 없다.
    // numbers의 접근 제어자인 private는 변경할 수 없다.
    // Lotto의 패키지를 변경할 수 있다.
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        repeatValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void repeatValidate(List<Integer> numbers) {
        if (repetition(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private boolean repetition(List<Integer> numbers) {
        ArrayList<Integer> previousValue = new ArrayList<>();

        for (Integer number : numbers) {
            if (previousValue.contains(number)) {
                return true;
            }
            previousValue.add(number);
        }
        return false;
    }

    public List<Integer> getLotto(){
        // List 정렬하는 방법
        Collections.sort(numbers);
        return numbers;
    }
}
