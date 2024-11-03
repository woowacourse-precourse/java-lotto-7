package lotto.model;


import lotto.LottoWinningRank;

import java.util.*;

public class LottoResultChecker {
    // 발급된 로또 리스트
    private List<Lotto> purchaseLottoList;
    // 입력한 당첨 로또
    private Lotto prizeLotto;

    private Integer bonusNumber;

    private Map<LottoWinningRank, Integer> lottoResultMap;

    private String profitMargin;

    public LottoResultChecker(List<Lotto> purchaseLottoList, List<Integer> prizeNumbers, Integer bonusNumber, Integer buyPrice) {
        this.purchaseLottoList = purchaseLottoList;
        this.prizeLotto = new Lotto(prizeNumbers);
        this.bonusNumber = bonusNumber;
        this.lottoResultMap = setLottoResult(getPurchaseEnumList());
        this.profitMargin = setProfitMargin(buyPrice);
    }

    public List<Integer> getPrizeResult() {
        List<Integer> prizeCount = new ArrayList<>();
        for (int i = 0; i < purchaseLottoList.size(); i++) {
            prizeCount.add(i, getPrizeCount(purchaseLottoList.get(i), prizeLotto));
        }
        return prizeCount;
    }


    private Integer getPrizeCount(Lotto purchaseLotto, Lotto prizeLotto) {
        Integer prize = 0;
        for (int i = 0; i < 6; i++) {
            if (prizeLotto.getNumbers().contains(purchaseLotto.getNumbers().get(i))) {
                prize++;
            }
        }
        return prize;
    }

    public List<Boolean> getPrizeBonusNumberList() {
        List<Boolean> isPrizeBonus = new ArrayList<>();
        for (int i = 0; i < purchaseLottoList.size(); i++) {
            isPrizeBonus.add(i, getBonusPrize(purchaseLottoList.get(i)));
        }

        return isPrizeBonus;
    }

    private Boolean getBonusPrize(Lotto purchaseLotto) {
        if (purchaseLotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public List<LottoWinningRank> getPurchaseEnumList() {
        var resultPrizeCountList = getPrizeResult();
        var resultIsBonusCountList = getPrizeBonusNumberList();
        List<LottoWinningRank> resultList = new ArrayList<>();

        for (int i = 0; i < resultPrizeCountList.size(); i++) {
            resultList.add(checkRankEnum(resultPrizeCountList.get(i), resultIsBonusCountList.get(i)));
        }

        return resultList;
    }

    private LottoWinningRank checkRankEnum(Integer prizeCount, Boolean isPrizeBonus) {
        var rankMap = createPrizeRank();
        String key = prizeCount + ":" + isPrizeBonus;
        return rankMap.getOrDefault(key, LottoWinningRank.FAIL);
    }

    private Map<LottoWinningRank, Integer> setLottoResult(List<LottoWinningRank> purchaseEnumList) {
        Map<LottoWinningRank, Integer> resultMap = new HashMap<LottoWinningRank, Integer>();

        for (LottoWinningRank resultType : LottoWinningRank.values()) {
            int frequency = Collections.frequency(purchaseEnumList, resultType);
            resultMap.put(resultType, frequency);
        }

        return resultMap;
    }

    private String setProfitMargin(Integer buyPrice) {
        Integer allPrice = 0;
        for (Map.Entry<LottoWinningRank, Integer> prizeEntry : lottoResultMap.entrySet()) {
            allPrice += prizeEntry.getKey().getPrizePrice() * prizeEntry.getValue();
        }

        double parseAllPrice = (double) allPrice;

        return ((double)(parseAllPrice / buyPrice) * 100) + "%";
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

    public Map<LottoWinningRank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

    public String getProfitMargin() {
        return profitMargin;
    }
}
