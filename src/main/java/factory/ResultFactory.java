package factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Lotto;
import model.Amount;
import model.BonusNumber;
import model.LottoCollection;
import model.WinningLottoNum;

public class ResultFactory {

    private final LottoCollection lottoCollection;
    private final WinningLottoNum winningLottoNum;
    private final BonusNumber bonusNumber;
    private final int FIRST = 1;
    private final int SECOND = 2;
    private final int THIRD = 3;
    private final int FOURTH = 4;
    private final int FIFTH = 5;
    private final int FIRST_PRIZE = 2000000000;
    private final int SECOND_PRIZE = 30000000;
    private final int THIRD_PRIZE = 1500000;
    private final int FOURTH_PRIZE = 50000;
    private final int FIFTH_PRIZE = 5000;
    private Map<Integer, Integer> result;

    public ResultFactory(LottoCollection lottoCollection
        , WinningLottoNum winningLottoNum, BonusNumber bonusNumber) {
        this.lottoCollection = lottoCollection;
        this.winningLottoNum = winningLottoNum;
        this.bonusNumber = bonusNumber;
        result = initResult();
    }

    private Map<Integer, Integer> initResult() {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i <= FIFTH; i++) {
            result.put(i, 0);
        }
        return result;
    }

    public Map<Integer, Integer> getResult() {
        List<Lotto> lottos = lottoCollection.getLottos();
        for (Lotto lotto : lottos) {
            int winPosition = checkLottoResult(lotto, winningLottoNum, bonusNumber);
            int winCount = result.get(winPosition);
            winCount += 1;
            result.put(winPosition, winCount);
        }
        return result;
    }

    public float getEarningRate(Amount amount) {
        int purchaseAmount = amount.getPurchaseAmount();
        int prizeAmount = 0;
        prizeAmount += result.get(FIRST) * FIRST_PRIZE;
        prizeAmount += result.get(SECOND) * SECOND_PRIZE;
        prizeAmount += result.get(THIRD) * THIRD_PRIZE;
        prizeAmount += result.get(FOURTH) * FOURTH_PRIZE;
        prizeAmount += result.get(FIFTH) * FIFTH_PRIZE;

        return prizeAmount / (float) purchaseAmount * 100;
    }


    private int checkLottoResult(Lotto lotto, WinningLottoNum winningLottoNum, BonusNumber bonusNumber) {
        int intersectCount = intersectNumCount(lotto, winningLottoNum);
        if (intersectCount == 6) {
            return FIRST;
        }
        if (intersectCount == 5 && isContainBonus(lotto)) {
            return SECOND;
        }
        if (intersectCount == 5) {
            return THIRD;
        }
        if (intersectCount == 4) {
            return FOURTH;
        }
        if (intersectCount == 3) {
            return FIFTH;
        }
        return 0;
    }

    private int intersectNumCount(Lotto lotto, WinningLottoNum winningLottoNum) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.retainAll(winningLottoNum.getWinningNums());
        return numbers.size();
    }

    private boolean isContainBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.get());
    }
}
