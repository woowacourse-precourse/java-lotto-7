package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public Rank countMatchNumber(Lotto winningNumber, int bonusNumber) {
        long matchCount = this.numbers.stream()
                .filter(n -> winningNumber.numbers.stream().anyMatch(Predicate.isEqual(n)))
                .count();
        boolean bonusMatch = this.numbers.stream().anyMatch(Predicate.isEqual(bonusNumber));
        return Rank.findRank(matchCount, bonusMatch);
    }


}
