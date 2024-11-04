package lotto.model;

import lotto.dto.PurchaseAmountDto;
import lotto.utils.CheckLotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.properties.LottoProperties.LOTTO_PRICE;

public class MyLottoInfo {

    private final int purchaseAmount;
    private final int purchaseLottoCount;
    private final Revenue revenue;
    private final List<Lotto> myLotteries;
    private final Map<Rank, Integer> myResult;

    private MyLottoInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.revenue = Revenue.init(purchaseAmount);
        this.purchaseLottoCount = calculateQuantities();
        this.myLotteries = generateLotto();
        this.myResult = initResult();
    }

    private Map<Rank, Integer> initResult(){
        Map<Rank, Integer> result = new LinkedHashMap<>();
        result.put(Rank.NONE, 0);
        result.put(Rank.FIFTH_PLACE, 0);
        result.put(Rank.FOURTH_PLACE, 0);
        result.put(Rank.THIRD_PLACE, 0);
        result.put(Rank.SECOND_PLACE, 0);
        result.put(Rank.FIRST_PLACE, 0);
        return result;
    }

    public void getResultPerLotto(WinningLotto winningLotto) {
        myLotteries.forEach(lotto -> {
                    Rank rank = Rank.findRank(
                            CheckLotto.countEqualLottoNumbers(lotto, winningLotto.getWinningLotto().getNumbers()),
                            CheckLotto.checkContainsBonusNumber(lotto, winningLotto.getBonusNumber())
                    );
                    updateResult(rank);
                    revenue.updateRevenue(rank);
                }
        );
    }

    public void calculateRevenueRate(){
        revenue.updateRevenueRate();
    }

    private int calculateQuantities(){
        return this.purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> generateLotto(){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < this.purchaseLottoCount; i++){
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    private void updateResult(Rank rank) {
        myResult.put(rank, myResult.get(rank) + 1);
    }

    public List<Lotto> getMyLotteries() {
        return myLotteries;
    }

    public Revenue getRevenue() {
        return revenue;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public Map<Rank, Integer> getMyResult() {
        return myResult;
    }

    public static MyLottoInfo from(PurchaseAmountDto dto){
        return new MyLottoInfo(
                dto.purchaseAmount()
        );
    }
}
