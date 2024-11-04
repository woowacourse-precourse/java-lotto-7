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

    public Map<Object, Integer> checkLottoWin(List<List<Integer>> randomNumberList, Integer bonusNumber) {
        Map<Object, Integer> checkLotto = new HashMap<>();
        checkLotto.put(3, 0);
        checkLotto.put(4, 0);
        checkLotto.put(5, 0);
        checkLotto.put(6, 0);
        checkLotto.put("bonus", 0);

        for (List<Integer> randomNumbers : randomNumberList) {
            Object matchResult = countLottoMatchesWithBonus(numbers, bonusNumber, randomNumbers);
            if (matchResult != null) {
                checkLotto.put(matchResult, checkLotto.get(matchResult) + 1);
            }
        }
        return checkLotto;
    }

    private Object countLottoMatchesWithBonus(
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
        if (matchCount >= 3){
            return matchCount;
        }
        return null;
    }
}
