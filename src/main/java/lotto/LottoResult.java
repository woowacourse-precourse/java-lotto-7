package lotto;

import static lotto.CorrectStatus.findByMatchCountAndSpecialNumber;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    Map<CorrectStatus,Integer> winningStatistics = new LinkedHashMap<>();

    public LottoResult(){

        winningStatistics.put(CorrectStatus.THREE_CORRECT,0);
        winningStatistics.put(CorrectStatus.FOUR_CORRECT,0);
        winningStatistics.put(CorrectStatus.FIVE_CORRECT_WITH_NO_SPECIAL_NUMBER,0);
        winningStatistics.put(CorrectStatus.FIVE_CORRECT_WITH_SPECIAL_NUMBER,0);
        winningStatistics.put(CorrectStatus.SIX_CORRECT,0);

    }

    public LottoResult adjustLottoResult(final WinningLottoNumberSelector winningLottoNumberSelector){

        winningLottoNumberSelector.getPurchasedLottos().forEach(purchasedLotto ->{
            int matchNumber = winningLottoNumberSelector.matchNumber(purchasedLotto);
            if(matchNumber>=3){

                CorrectStatus correctStatus = getCorrectStatus(winningLottoNumberSelector, matchNumber,purchasedLotto);
                winningStatistics.put(correctStatus, winningStatistics.get(correctStatus)+1);
            }
        });

        return this;
    }

    public Map<CorrectStatus,Integer> getWinningStatistics(){
        return this.winningStatistics;
    }

    public int profit(){

        return winningStatistics.keySet().stream()
                .mapToInt(correctStatus -> correctStatus.getReward() * winningStatistics.get(correctStatus))
                .sum();
    }

    private  CorrectStatus getCorrectStatus(final WinningLottoNumberSelector winningLottoNumberSelector,
                                            final int matchNumber,final Lotto purchasedLotto) {

        boolean containSpecialNumber = winningLottoNumberSelector.containSpecialNumber(purchasedLotto);
        CorrectStatus correctStatus = findByMatchCountAndSpecialNumber(matchNumber,containSpecialNumber);

        return correctStatus;
    }
}
