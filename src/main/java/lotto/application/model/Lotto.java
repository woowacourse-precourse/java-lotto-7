package lotto.application.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.common.Errors;

public class Lotto implements Model {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Errors.IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if(numbers.stream().distinct().count() != numbers.size()) {
            Errors.IllegalArgumentException("로또 번호는 중복이 불가합니다.");
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString(){
        return Arrays.toString(numbers.toArray());
    }

    public WinningRanking match(List<Integer> winningNumber, int bonusNumber){
        int count = (int) this.numbers.stream()
                .filter(winningNumber::contains)
                .count();

        if(count==5 && this.numbers.contains(bonusNumber)) return WinningRanking.SECOND;

        //TODO: 보너스 번호 매칭됐는지 여부를 판별하는 메소드로 따로 뺄 수 있겠다.
        return WinningRanking.findByCountAndBonus(count, numbers.contains(bonusNumber));
    }
}
