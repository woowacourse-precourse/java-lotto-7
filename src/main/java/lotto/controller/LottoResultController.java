package lotto.controller;

import lotto.LottoWinningRank;
import lotto.model.Lotto;
import lotto.model.LottoResultChecker;

import java.lang.reflect.Type;
import java.util.*;

public class LottoResultController {
    private LottoResultChecker resultChecker;
    private Map<LottoWinningRank, Integer> lottoResultMap;
    private String profitMargin;
    // 발급 로또 리스트, 당첨 번호, 보너스 번호, 구매 금액
    public LottoResultController(List<Lotto> purchaseLottoList, List<Integer> prizeNumbers, Integer bonusNumber,Integer buyPrice) {
        this.resultChecker = new LottoResultChecker(purchaseLottoList, prizeNumbers, bonusNumber);
        setLottoResult(getPurchaseEnumList());
        setProfitMargin(buyPrice);
    }

    public List<LottoWinningRank> getPurchaseEnumList() {
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

    private void setLottoResult(List<LottoWinningRank> purchaseEnumList) {
        Map<LottoWinningRank, Integer> resultMap = new HashMap<LottoWinningRank, Integer>();

        for (LottoWinningRank resultType : LottoWinningRank.values()) {
            int frequency = Collections.frequency(purchaseEnumList, resultType);
            resultMap.put(resultType, frequency);
        }

        this.lottoResultMap = resultMap;
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

    private void setProfitMargin(Integer buyPrice) {
        Integer allPrice = 0;
        for (Map.Entry<LottoWinningRank, Integer> prizeEntry : lottoResultMap.entrySet()) {
            allPrice += prizeEntry.getKey().getPrizePrice() * prizeEntry.getValue();
        }

        this.profitMargin = ((allPrice / buyPrice) * 100) + "%";
    }
}
