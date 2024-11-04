package lotto;

import static lotto.CorrectStatus.findByMatchCountAndSpecialNumber;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    Map<CorrectStatus,Integer> winningStatistics = new LinkedHashMap<>();

    private static final int DEFAULT_COUNT = 0;

    private static final int DEFAULT_CORRECT_COUNT = 3;

    public LottoResult(){

        winningStatistics.put(CorrectStatus.THREE_CORRECT,DEFAULT_COUNT);
        winningStatistics.put(CorrectStatus.FOUR_CORRECT,DEFAULT_COUNT);
        winningStatistics.put(CorrectStatus.FIVE_CORRECT_WITH_NO_SPECIAL_NUMBER,DEFAULT_COUNT);
        winningStatistics.put(CorrectStatus.FIVE_CORRECT_WITH_SPECIAL_NUMBER,DEFAULT_COUNT);
        winningStatistics.put(CorrectStatus.SIX_CORRECT,DEFAULT_COUNT);

    }

    public LottoResult adjustLottoResult(final WinningLottoNumberSelector winningLottoNumberSelector){

        winningLottoNumberSelector.getPurchasedLottos().forEach(purchasedLotto ->{
            int matchNumber = winningLottoNumberSelector.matchNumber(purchasedLotto);
            if(matchNumber>=DEFAULT_CORRECT_COUNT){

                CorrectStatus correctStatus = getCorrectStatus(winningLottoNumberSelector, matchNumber,purchasedLotto);
                winningStatistics.put(correctStatus, winningStatistics.get(correctStatus)+1);
            }
        });

        return this;
    }

    public Map<CorrectStatus,Integer> getWinningStatistics(){
        return this.winningStatistics;
    }

    public long profit(){

        return winningStatistics.keySet().stream()
                .mapToLong(correctStatus -> (long) correctStatus.getReward() * winningStatistics.get(correctStatus))
                .sum();
    }

    private  CorrectStatus getCorrectStatus(final WinningLottoNumberSelector winningLottoNumberSelector,
                                            final int matchNumber,final Lotto purchasedLotto) {

        boolean containSpecialNumber = winningLottoNumberSelector.containSpecialNumber(purchasedLotto);
        CorrectStatus correctStatus = findByMatchCountAndSpecialNumber(matchNumber,containSpecialNumber);

        return correctStatus;
    }
}
