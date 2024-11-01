package lotto.model;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
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
    public Result compareWithWinningLotto(Lotto userLotto, List<Integer> winningLotto, int bonusNumber){
        boolean isBonusMatch = false;
        List<Integer> duplicateNumber = userLotto.numbers.stream().filter(o -> winningLotto.stream()
                .noneMatch(Predicate.isEqual(o))).toList();
        if(userLotto.numbers.contains(bonusNumber)){
            isBonusMatch = true;
        }
        return Result.findResult(duplicateNumber.size(),isBonusMatch);
    }
}
