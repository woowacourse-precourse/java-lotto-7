package lotto.model;

import lotto.utils.LottoUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyLottoInfo {

    private final List<Lotto> myLotteries;
    private final Map<Rank, Integer> myResult;

    private MyLottoInfo(List<Lotto> myLotteries) {
        this.myLotteries = myLotteries;
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

    public List<Rank> getResultPerLotto(WinningLotto winningLotto) {
        List<Rank> lottoRanks = new ArrayList<>(myLotteries.size());
        myLotteries.forEach(lotto -> {
                    Rank rank = Rank.findRank(
                            LottoUtils.countEqualLottoNumbers(lotto, winningLotto.getWinningLotto().getNumbers()),
                            LottoUtils.checkContainsBonusNumber(lotto, winningLotto.getBonusNumber())
                    );
                    lottoRanks.add(rank);
                }
        );
        updateResult(lottoRanks);
        return lottoRanks;
    }

    public List<Lotto> getMyLotteries() {
        return myLotteries;
    }

    private void updateResult(List<Rank> ranks){
        ranks.forEach(rank -> myResult.put(rank, myResult.get(rank) + 1));
    }

    public Map<Rank, Integer> getMyResult() {
        return myResult;
    }

    public static MyLottoInfo from(int count){
        List<Lotto> myLotteries = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            myLotteries.add(Lotto.generate());
        }
        return new MyLottoInfo(myLotteries);
    }

}
