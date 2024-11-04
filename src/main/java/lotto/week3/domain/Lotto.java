package lotto.week3.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;


    /*
      NOTE 불변객체로 생성 : 객체 무결성을 보장함으로 사용함
     */
  public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
