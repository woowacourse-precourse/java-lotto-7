package lotto.controller;

import static lotto.model.Winning.toStringWithoutNone;

import java.util.List;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class LottoController {

    private final Lottos lottos;
    private final LottoView view;
    private final LottoValue lottoValue;

    public LottoController(Lottos lottos, LottoView view, LottoValue lottoValue) {
        this.lottos = lottos;
        this.view = view;
        this.lottoValue = lottoValue;
    }

    public void setAndPrintLottos() {
        view.printLottoCount(lottoValue.lottoCount());
        lottos.allocateLottosByRandomNumber(lottoValue.lottoCount());
        view.printLottoNumbers(lottos.toStringAllLottoNumber());
    }

    public List<Integer> getWinningNumber() {
        return view.inputWinningNumber();
    }

    public int getBonusNumber() {
        return view.inputBonusNumber();
    }

    public void confirmWinning(List<Integer> winningNumber, int bonusNumber) {
        lottos.setByCorrectCount(winningNumber, bonusNumber);
        view.printWinningTrace(toStringWithoutNone());
    }

    public void printAndCalculateWinningRate() {
        String winningRate = getWinningRate();
        view.printWinningRate(winningRate);
    }

    private String getWinningRate() {
        return lottos.calculateWinningRate(lottoValue.lottoPrice())
                .toPlainString();
    }
}
