package lotto.domain;


import static lotto.exception.printException.throwIllegalArgException;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.exception.ErrorMessage;

public class Game {
    private static final int LOTTO_MAX_COUNT = 100;
    private static final int[] PRIZE_AMOUNTS = {5000, 50000, 1500000, 30000000, 2000000000};

    private final List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;
    private List<Lotto> winningLottos;

    public Game(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        validateLottoMaxCount(lottos);

        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.winningLottos = new ArrayList<>();
    }

    public Game(List<Lotto> lottos) {
        validateLottoMaxCount(lottos);
        this.lottos = lottos;
    }

    // 당첨 결과 비교
    public Map<Winning, Integer> compareNumbers(Lotto winningLotto) {
        Map<Winning, Integer> results = new EnumMap<>(Winning.class);

        for (Lotto lotto : lottos) {
            int correctCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Winning winning = Winning.valueOf(correctCount, bonusMatch);
            if (winning != null) {
                results.put(winning, results.getOrDefault(winning, 0) + 1);
            }
        }

        return results;
    }


    public double calculateRateOfReturn(int purchaseAmount, Map<Winning, Integer> results) {
        int revenue = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((double) revenue / purchaseAmount) * 100.0;
    }


    private void validateLottoMaxCount(List<Lotto> lottos) {
        if (lottos.size() > LOTTO_MAX_COUNT) {
            throwIllegalArgException(ErrorMessage.MAX_LOTTO_COUNT_ERROR);
        }
    }
}
