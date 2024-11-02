package lotto.model;

import java.util.List;
import lotto.Result;

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

        for (int n : numbers) {
            if (!(n >= 1 && n <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 인 정수를 입력 해야 합니다.");
            }
        }

        List<Integer> distinctList = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 되는 로또 번호가 없어야 합니다.");
        }
    }

    private void bonusNumberDistinctValidate(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복 되지 않는 보너스 번호를 사용 해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void matcheNumber(List<List<Integer>> lotteryTickets, int bonusNumber) {
        bonusNumberDistinctValidate(bonusNumber);
        for (List<Integer> lts : lotteryTickets) {
            int count = matchCount(lts, bonusNumber);
            resultCountUp(count);
        }
    }

    private int matchCount(List<Integer> lts, int bonusNumber) {
        int count = 0;
        for (Integer n : lts) {
            if (numbers.contains(n)) {
                count++;
            }
        }

        if (count == 5 && lts.contains(bonusNumber)) {
            count += 2;
        }
        return count;
    }

    private void resultCountUp(int count) {
        for (Result result : Result.values()) {
            if (result.getMatches() == count) {
                result.increamentCount();
            }
        }
    }
}
