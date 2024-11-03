package lotto;

import java.util.List;

public class LottoDrawer {
    private final LottoMachine lottoMachine;
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;


    public LottoDrawer(LottoMachine lottoMachine, List<Integer> winningLottoNumbers, int bonusNumber) {
        this.lottoMachine = lottoMachine;
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkWinningNumbers() {

        for (List<Integer> lottos:lottoMachine.getLottoNumbers()){
            int winningCount=0;
            int bonusCount=0;

            bonusCount += (int)lottos.stream().filter(e -> e.equals(bonusNumber)).distinct().count();
            for (Integer lotto:lottos){
                winningCount += (int)winningLottoNumbers.stream().filter(e -> e.equals(lotto)).distinct().count();

            }
            LottoResult lottoResult = new LottoResult(winningCount,bonusCount);
            lottoResult.checkWinningLotto();
        }
    }

    public void getWinningCount() {
        checkWinningNumbers();
    }





}
