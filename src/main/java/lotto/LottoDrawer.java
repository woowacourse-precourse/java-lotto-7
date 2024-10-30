package lotto;

import java.util.List;

public class LottoDrawer {
    LottoMachine lottoMachine;
    List<Integer> winningLottoNumbers;
    Integer bonusNumber;
    long winningCount;

    public LottoDrawer(LottoMachine lottoMachine, List<Integer> winningLottoNumbers, Integer bonusNumber) {
        this.lottoMachine = lottoMachine;
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkWinningNumbers() {
        for (List<Integer> lottos:lottoMachine.getLottoNumbers()){
            for (Integer lotto:lottos)
                winningCount += winningLottoNumbers.stream().filter(e -> e.equals(lotto)).distinct().count();
        }
    }

    public long getWinningCount() {
        checkWinningNumbers();
        return winningCount;
    }





}
