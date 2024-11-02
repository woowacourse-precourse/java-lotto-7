package lotto;

import input.LottoWinnerNumberInputProcessor;
import java.util.List;

public class WinnerManager {

    private Lotto winnerLotto;
    private LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor;

    WinnerManager(LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor) {
        this.lottoWinnerNumberInputProcessor = lottoWinnerNumberInputProcessor;
    }

    public void registerWinnerLotto() {
        List<Integer> registedLottoNumber;
        while (true) {
            registedLottoNumber = lottoWinnerNumberInputProcessor.putValue();
            try {
                winnerLotto = new Lotto(registedLottoNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
