package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private static final int LOTTERY_NUM_RANGE_FIRST = 1;
    private static final int LOTTERY_NUM_RANGE_LAST = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> checkDuplicateNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (checkDuplicateNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
            checkDuplicateNumbers.add(number);
        }
    }

    public static Lotto generateLottoTicket() {
        List<Integer> lottoTicket = Randoms.pickUniqueNumbersInRange(LOTTERY_NUM_RANGE_FIRST, LOTTERY_NUM_RANGE_LAST, LOTTERY_NUMBER_COUNT);
        return new Lotto(lottoTicket);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public long getMatchCount(WinningLotto winningLotto) {
        long matchCount = numbers.stream()
                .filter(winningLotto::isWinningNumber)
                .count();

        return matchCount;
    }

    public boolean isBonusNumberMatched(WinningLotto winningLotto) {
        for (Integer number : numbers) {
            if (winningLotto.isBonusNumber(number)) {
                return true;
            }
        }
        return false;
    }

}
