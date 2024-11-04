package lotto.application.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lotto implements Model {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
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

        return WinningRanking.findWinningRankingByMatchedCount(count);
    }
}
