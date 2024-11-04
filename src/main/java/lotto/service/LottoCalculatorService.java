package lotto.lottoMachine;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    public LottoResult getResult(List<Lotto> userLottos,
                                 Lotto winningLotto,
                                 Integer bonusNumber,
                                 Integer purchaseNum) {
        Map<LottoRank, Integer> resultMap = calculateResultMap(userLottos, winningLotto, bonusNumber);
        Double totalProfit = calculateTotalProfit(resultMap);
        Double ratioOfProfit = calculateProfitRatio(totalProfit, purchaseNum);
        return new LottoResult(resultMap, ratioOfProfit);
    }

    protected Map<LottoRank, Integer> calculateResultMap(List<Lotto> userLottos, Lotto winningLotto, Integer bonusNumber) {
        Map<LottoRank, Integer> resultMap = initResultMap();

        for (Lotto userLotto : userLottos) {
            LottoRank lottoRank = calculateMatchCount(userLotto, winningLotto, bonusNumber);
            if (lottoRank != null) {
                resultMap.put(lottoRank, resultMap.get(lottoRank) + 1);
            }
        }

        return resultMap;
    }

    protected Map<LottoRank, Integer> initResultMap() {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);
        for(LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }

        return resultMap;
    }

    protected LottoRank calculateMatchCount(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> numbers = userLotto.getNumbers();
        int count = (int) numbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        if(count == 6) {
            return LottoRank.FIRST;
        } else if(count == 5 && numbers.contains(bonusNumber)) {
            return LottoRank.SECOND;
        } else if(count == 5) {
            return LottoRank.THIRD;
        } else if(count == 4) {
            return LottoRank.FOURTH;
        } else if(count == 3) {
            return LottoRank.FIFTH;
        }
        return null;
    }

    protected Double calculateTotalProfit(Map<LottoRank, Integer> resultMap) {
        double totalProfit = 0;
        for (LottoRank lottoRank : resultMap.keySet()) {
            totalProfit += (lottoRank.getWinningAmount() * resultMap.get(lottoRank));
        }

        return totalProfit;
    }

    protected Double calculateProfitRatio(Double totalProfit, Integer purchaseNum) {
        return totalProfit / (purchaseNum * 1000) * 100;
    }
}
