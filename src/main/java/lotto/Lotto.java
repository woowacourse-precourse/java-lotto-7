package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

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

    public static Lotto generateWinningNumbers() {
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(winningNumbers);
    }

    public static int generateBonusNumber(Lotto winningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers.numbers);
        int bonusNumber;

        do {
            bonusNumber = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, 1).get(0);
        } while (uniqueWinningNumbers.contains(bonusNumber));

        return bonusNumber;
    }
}
