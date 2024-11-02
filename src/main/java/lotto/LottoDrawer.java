package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoDrawer {
    LottoMachine lottoMachine;
    List<Integer> winningLottoNumbers;
    int bonusNumber;


    public LottoDrawer(LottoMachine lottoMachine, List<Integer> winningLottoNumbers, int bonusNumber) {
        this.lottoMachine = lottoMachine;
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkWinningNumbers() {

        for (List<Integer> lottos:lottoMachine.getLottoNumbers()){
            int winningCount=0;
            int bonusCount=0;

            bonusCount += (int)lottos.stream().filter(e -> e.equals(bonusNumber)).distinct().count();
            for (Integer lotto:lottos){
                winningCount += (int)winningLottoNumbers.stream().filter(e -> e.equals(lotto)).distinct().count();

            }
            LottoResult lottoResult = new LottoResult(winningCount,bonusCount);
            lottoResult.tt();
        }
    }

    public void getWinningCount() {
        checkWinningNumbers();
    }





}
