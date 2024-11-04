package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }
    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> (number >= 1) && (number <= 45));
    }
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
    public WinningStatus getWinningStatus(Lotto winLotto, int bonusNumber) {
        List<Integer> numbers = winLotto.getNumbers();
        long duplicatedNumbers = this.numbers.stream()
                .filter(numbers::contains)
                .count();
        if (duplicatedNumbers == 6) {
            return WinningStatus.FIRST_PLACE;
        }
        if (duplicatedNumbers == 5 && numbers.contains(bonusNumber)) {
            return WinningStatus.SECOND_PLACE;
        }
        if (duplicatedNumbers == 5) {
            return WinningStatus.THIRD_PLACE;
        }
        if (duplicatedNumbers == 4) {
            return WinningStatus.FOURTH_PLACE;
        }
        if (duplicatedNumbers == 3) {
            return WinningStatus.FIFTH_PLACE;
        }
        return WinningStatus.NO_WIN;
    }
}
