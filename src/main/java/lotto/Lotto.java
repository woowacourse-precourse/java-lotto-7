package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public static void checkLottoWin(List<List<Integer>> lottoNumbersList, List<Integer> lotto) {
        int bonusNumber = lotto.getLast();
        Map<Object, Integer> checkLotto = new HashMap<>();

        for (List<Integer> lottoNumbers : lottoNumbersList) {
            int matchCount = 0;

            for (Integer number : lottoNumbers) {
                if (lotto.contains(number)) {
                    matchCount++;
                }
            }

            if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) {
                checkLotto.put("bonus", checkLotto.getOrDefault("bonus", 0) + 1);
            } else {
                checkLotto.put(matchCount, checkLotto.getOrDefault(matchCount, 0) + 1);
            }
        }
    }
}
