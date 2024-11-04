package lotto;

import lotto.constant.LottoResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoJudger {

    private Map<LottoResult, Integer> statisticMap = new HashMap<>();

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoJudger(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initStatisticMap();
    }


    public Map<LottoResult, Integer> judge(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            LottoResult result = judgeLotto(lotto);
            statisticMap.put(result, statisticMap.get(result) + 1);
        }

        return statisticMap;
    }

    private LottoResult judgeLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int count = getCountOfWinningNumbersInLottoNumbers(lottoNumbers);
        boolean isBonus = lottoNumbers.contains(this.bonusNumber);

        if (count == 6)
            return LottoResult.ALL;
        if (count == 5 && isBonus)
            return LottoResult.FIVE_AND_BONUS;
        if (count == 5)
            return LottoResult.FIVE;
        if (count == 4)
            return LottoResult.FOUR;
        if (count == 3)
            return LottoResult.THREE;
        return LottoResult.NONE;
    }

    private int getCountOfWinningNumbersInLottoNumbers(List<Integer> lottoNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private void initStatisticMap() {
        for (LottoResult result : LottoResult.values()) {
            statisticMap.put(result, 0);
        }
    }
}

