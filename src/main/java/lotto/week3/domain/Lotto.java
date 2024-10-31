package lotto.week3.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public int matchCount(List<Integer> winningNumber){
        return (int) numbers.stream().filter(winningNumber::contains).count();
    }
    public boolean contains(int number){
        return numbers.contains(number);
    }

}
