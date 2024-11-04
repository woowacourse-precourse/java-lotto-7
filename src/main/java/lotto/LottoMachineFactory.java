package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMachineFactory {

    private LottoFactory lottoFactory;

    private WinningFactory winningFactory;

    public LottoMachineFactory() {
        lottoFactory = new LottoFactory();
        winningFactory = new WinningFactory();
    }

    public LottoMachine createLottoMachine(Lotto winningLotto, int bonusNumber) {
        return new LottoMachine(winningLotto, bonusNumber, winningFactory.createWinningTypes());
    }
}
