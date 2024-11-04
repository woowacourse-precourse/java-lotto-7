package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCalculator {
    static Lotto getAutoLottoOneSet() {
        List<Integer> aLottoSet = new ArrayList<>();
        Integer randomNumber;
        while (aLottoSet.size() < 6) {
            randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!aLottoSet.contains(randomNumber)) {
                aLottoSet.add(randomNumber);
            }
        }
        Lotto lotto = new Lotto(aLottoSet);
        return lotto;
    }

    static List<Lotto> getLottoSetsAsInputAmount(Integer input) {
        List<Lotto> lottoFullSets = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            lottoFullSets.add(getAutoLottoOneSet());
        }
        return lottoFullSets;
    }

    static List<LottoWinner> getFullLottoResult(List<Lotto> boughtLottoSet, Lotto winLottoSet,
                                                Integer bonusNumber) {
        List<Integer> amountCreiteriaList = Arrays.asList(3, 4, 5, 5, 6);
        List<Integer> winPrizeList = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);
        List<Boolean> hasBonusBallList = Arrays.asList(false, false, false, true, false);
        List<LottoWinner> lottoWinnerList = new ArrayList<>();
        getLottoSetContainBonusNumber(winLottoSet, bonusNumber);
        Lotto processedWinLottoSet;
        for (int i = 0; i < 5; i++) {
            processedWinLottoSet = getProcessedWinLottoSet(winLottoSet, bonusNumber, hasBonusBallList, i);
            lottoWinnerList.add(
                    getASetLottoWinner(amountCreiteriaList.get(i), winPrizeList.get(i), hasBonusBallList.get(i),
                            boughtLottoSet, processedWinLottoSet));
        }
        return lottoWinnerList;
    }

    private static Lotto getProcessedWinLottoSet(Lotto winLottoSet, Integer bonusNumber,
                                                         List<Boolean> hasBonusBallList,
                                                         int i) {
        Lotto winLottoSetProcessed = new Lotto(winLottoSet.getNumbers());
        if (hasBonusBallList.get(i)) //보너스로 진행하게
        {
            winLottoSetProcessed = getLottoSetContainBonusNumber(winLottoSet, bonusNumber);
        }
        return winLottoSetProcessed;
    }

    private static Lotto getLottoSetContainBonusNumber(Lotto winLottoSet, Integer bonusNumber) {
        Lotto winLottoSetContainBonus = winLottoSet;
        winLottoSetContainBonus.getNumbers().add(bonusNumber);
        return winLottoSetContainBonus;
    }

    static LottoWinner getASetLottoWinner(Integer amountCriteria, Integer winPrize, Boolean hasBonusBall,
                                          List<Lotto> boughtLottoSet, Lotto winLottoSet) {
        LottoWinner lottoWinnerData = new LottoWinner();
        lottoWinnerData.setAmountCriteria(amountCriteria);
        lottoWinnerData.setWinPrize(winPrize);
        Integer winAmount = 0;
        if (hasBonusBall) {
            lottoWinnerData.setBonusBallMent(lottoWinnerData.getBonusBallMent() + ", 보너스 볼 일치");
        }

        for (Lotto lottoSet : boughtLottoSet) {
            if (getALottoSetResult(lottoSet, winLottoSet) == amountCriteria) {
                winAmount++;
            }
        }
        lottoWinnerData.setWinAmount(winAmount);
        return lottoWinnerData;

    }

    //1개의 로또의 당첨 갯수를 리턴하는 함수
    private static Integer getALottoSetResult(Lotto boughtLottoASet, Lotto winLottoSet) {
        Integer matchNumberAmount = 0;
        for (Integer lottoNumber : boughtLottoASet.getNumbers()) {
            if (winLottoSet.getNumbers().contains(lottoNumber)) {
                matchNumberAmount++;
            }
        }
        return matchNumberAmount;
    }
}
