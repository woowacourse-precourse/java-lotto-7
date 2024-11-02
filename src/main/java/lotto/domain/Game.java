package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int LOTTO_MAX_COUNT = 100;

    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> winningLottos;

    public Game(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        validateLottoMaxCount(lottos);
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.winningLottos = new ArrayList<>();
    }

    public Game(List<Lotto> lottos) {
        validateLottoMaxCount(lottos);
        this.lottos = lottos;
    }

    // 당첨 결과 비교
    public int[] compareNumbers(List<Integer> winningNumbers) {
        int[] results = new int[5];

        for (Lotto lotto : lottos) {
            int correctCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            updateResults(results, correctCount, lotto);
        }

        return results;
    }

    private void updateResults(int[] results, int correctCount, Lotto lotto) {
        switch (correctCount) {
            case 3 -> results[0]++;
            case 4 -> results[1]++;
            case 5 -> checkBonusNumberMatch(results, lotto);
            case 6 -> results[4]++;
        }
        winningLottos.add(lotto);
    }

    private void checkBonusNumberMatch(int[] results, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            results[2]++;
            return;
        }
        results[3]++;
    }



    // 수익률 계산


    // 등록된 로또 최대 개수 검증
    private void validateLottoMaxCount(List<Lotto> lottos) {
        if (lottos.size() > LOTTO_MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 100개까지만 발행할 수 있습니다.");
        }
    }
}
