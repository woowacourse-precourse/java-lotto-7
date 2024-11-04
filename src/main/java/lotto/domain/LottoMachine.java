package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LottoMachine {

    private final int LOTTO_PRICE = 1000;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT = 6;

    public List<Lotto> generateLotto(int amount) {
        int quantity = amount / LOTTO_PRICE;

        return Stream.generate(
                () -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT)))
                .limit(quantity)
                .toList();
    }

    public Map<Integer, Integer> calculateStats(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.numbers();
            int sameCount = compareWinningNumber(lottoNumber, winningNumber, bonusNumber);

            updateMap(resultMap, sameCount);
        }

        return resultMap;
    }

    private int compareWinningNumber(List<Integer> lottoNumber, List<Integer> winningNumber, int bonusNumber) {
        int sameCount = (int) lottoNumber.stream()
                .filter(n -> winningNumber.stream()
                .anyMatch(Predicate.isEqual(n)))
                .count();

        if (sameCount == 5 && lottoNumber.contains(bonusNumber) || sameCount == 6) {
            return sameCount + 1;
        }

        return sameCount;
    }

    private void updateMap(Map<Integer, Integer> resultMap, int sameCount) {
        int prize = 8 - sameCount;
        resultMap.merge(prize, 1, Integer::sum);
    }

}
