package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

public class LottoService {
    public static final int BONUS_KEY = 55;
    private static final int CHECK_BONUS = 5;

    public List<Lotto> pickLottoNumbers(int lottoCount) {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
            .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
            .toList();
        lottos.forEach(lotto -> lotto.getNumbers().sort(null));
        return lottos;
    }

    public Map<Integer, Integer> checkWinningNumber(List<Lotto> lottos, List<Integer> myNumbers, Integer bonusNumber) {
        Map<Integer, Integer> winningCount = initNumberCount();
        int bonusCount = checkBonusPrize(lottos, myNumbers, bonusNumber);
        lottos.forEach(lotto -> {
            long matchCount = lotto.getNumbers().stream()
                .filter(myNumbers::contains)
                .count();
            if (matchCount >= 3) {
                winningCount.put((int) matchCount, winningCount.get((int) matchCount) + 1);
            }
            if (matchCount == CHECK_BONUS) {
                winningCount.put(BONUS_KEY, bonusCount);
                winningCount.put(CHECK_BONUS, winningCount.get(CHECK_BONUS) - bonusCount);
            }
        });
        return winningCount;
    }


    private Integer checkBonusPrize(List<Lotto> lottos, List<Integer> myNumbers, Integer bonusNumber) {
        return (int) lottos.stream()
            .filter(lotto -> {
                long matchCount = lotto.getNumbers().stream()
                    .filter(myNumbers::contains)
                    .count();
                return matchCount == CHECK_BONUS && lotto.getNumbers().contains(bonusNumber);
            })
            .count();
    }

    private Map<Integer, Integer> initNumberCount() {
        Map<Integer, Integer> matchCount = new HashMap<>();

        matchCount.put(3, 0);
        matchCount.put(4, 0);
        matchCount.put(5, 0);
        matchCount.put(6, 0);
        matchCount.put(BONUS_KEY, 0); // 5개 일치 + 보너스 번호

        return matchCount;
    }

}