package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.InputValidator;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        InputValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank match(WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(winningLotto.getWinningNumbers());
        boolean matchBonus = numbers.contains(winningLotto.getBonusNumber());
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int countMatchingNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}