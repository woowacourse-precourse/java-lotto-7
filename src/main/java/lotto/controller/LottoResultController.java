package lotto.controller;

import lotto.LottoWinningRank;
import lotto.model.Lotto;
import lotto.model.LottoResultChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultController {
    private LottoResultChecker resultChecker;

    public LottoResultController(List<Lotto> purchaseLottoList, List<Integer> prizeNumbers, Integer bonusNumber) {
        this.resultChecker = new LottoResultChecker(purchaseLottoList, prizeNumbers, bonusNumber);
    }

    public List<LottoWinningRank> getResultRank() {
        var resultPrizeCountList = resultChecker.getPrizeResult();
        var resultIsBonusCountList = resultChecker.getPrizeBonusNumberList();
        List<LottoWinningRank> resultList = new ArrayList<>();

        for (int i = 0; i < resultPrizeCountList.size(); i++) {
            resultList.add(checkRankEnum(resultPrizeCountList.get(i),resultIsBonusCountList.get(i)));
        }

        return resultList;
    }

    private LottoWinningRank checkRankEnum(Integer prizeCount, Boolean isPrizeBonus) {
        var rankMap = createPrizeRank();
        String key = prizeCount + ":" + isPrizeBonus;
        return rankMap.getOrDefault(key, LottoWinningRank.FAIL);
    }

    // if문을 여러개 사용할 수 없어 Map으로 선언 후 getKey를 사용하여 리턴함
    private Map<String, LottoWinningRank> createPrizeRank() {
        Map<String, LottoWinningRank> rankMap = new HashMap<>();

        rankMap.put("6:false", LottoWinningRank.FIRST);
        rankMap.put("5:true", LottoWinningRank.SECOND);
        rankMap.put("5:false", LottoWinningRank.THIRD);
        rankMap.put("4:false", LottoWinningRank.FOURTH);
        rankMap.put("3:false", LottoWinningRank.FIFTH);

        return rankMap;
    }
}
