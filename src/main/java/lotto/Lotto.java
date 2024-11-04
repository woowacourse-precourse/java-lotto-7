package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void checkLottoWin(List<List<Integer>> randomNumberList) {

        int bonusNumber = numbers.getLast();
        Map<Object, Integer> checkLotto = new HashMap<>();

        for (List<Integer> randomNumbers : randomNumberList) {
            Object matchResult = countLottoMatchesWithBonus(numbers, bonusNumber, randomNumbers);
            checkLotto.put(matchResult, checkLotto.getOrDefault(matchResult, 0) + 1);
        }
    }

    private static Object countLottoMatchesWithBonus(
            List<Integer> lottoNumbers,
            int bonusNumber,
            List<Integer> randomNumbers
    ) {
        int matchCount = 0;

        for (Integer number : randomNumbers) {
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) {
            return "bonus";
        }
        return matchCount;
    }
}
