package lotto.model;

import lotto.dto.PurchaseAmountDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.properties.LottoProperties.LOTTO_PRICE;

public class MyLottoInfo {

    private final List<Lotto> myLotteries;
    private final int purchaseAmount;
    private final int purchaseLottoCount;
    private final Map<Rank, Integer> myResult;
    private final int revenue;

    public MyLottoInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseLottoCount = calculateQuantities();
        this.myLotteries = generateLotto();
        this.myResult = initResult();
        this.revenue = 0;
    }

    public static MyLottoInfo from(PurchaseAmountDto dto){
        return new MyLottoInfo(
                dto.purchaseAmount()
        );
    }

    private Map<Rank, Integer> initResult(){
        Map<Rank, Integer> result = new LinkedHashMap<>();
        result.put(Rank.FIFTH_PLACE, 0);
        result.put(Rank.FOURTH_PLACE, 0);
        result.put(Rank.THIRD_PLACE, 0);
        result.put(Rank.SECOND_PLACE, 0);
        result.put(Rank.FIRST_PLACE, 0);
        return result;
    }

    private int calculateQuantities(){
        return this.purchaseLottoCount / LOTTO_PRICE;
    }

    private List<Lotto> generateLotto(){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < this.purchaseLottoCount; i++){
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    public void lottoResult(int count, boolean isBonusNumberMatch){
        Rank rank = Rank.findRank(count, isBonusNumberMatch);
        myResult.put(rank, myResult.get(rank) + 1);
    }

    public List<Lotto> getMyLotteries() {
        return myLotteries;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public Map<Rank, Integer> getMyResult() {
        return myResult;
    }
}
