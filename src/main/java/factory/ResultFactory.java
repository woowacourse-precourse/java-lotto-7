package factory;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import model.Lotto;
import model.Amount;
import model.BonusNumber;
import model.LottoCollection;
import model.Prize;
import model.WinningLottoNum;

public class ResultFactory {

    private final LottoCollection lottoCollection;
    private final WinningLottoNum winningLottoNum;
    private final BonusNumber bonusNumber;
    private Map<Prize, Integer> result;

    public ResultFactory(LottoCollection lottoCollection
        , WinningLottoNum winningLottoNum, BonusNumber bonusNumber) {
        this.lottoCollection = lottoCollection;
        this.winningLottoNum = winningLottoNum;
        this.bonusNumber = bonusNumber;
        result = initResult();
    }

    private Map<Prize, Integer> initResult() {
        result = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
            .forEach(prize -> result.put(prize, 0));
        return result;
    }

    public Map<Prize, Integer> getResult() {
        List<Lotto> lottos = lottoCollection.getLottos();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLottoNum);
            Prize prize = Prize.getPrize(matchCount, lotto.isContain(bonusNumber));
            result.put(prize, result.get(prize) + 1);
        }
        return result;
    }


    public float getEarningRate(Amount amount) {
        int purchaseAmount = amount.getPurchaseAmount();
        int prizeAmount = 0;
        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            prizeAmount += entry.getKey().getMoney() * entry.getValue();
        }
        return prizeAmount / (float) purchaseAmount * 100;
    }
}
