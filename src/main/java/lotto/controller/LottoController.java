package lotto.controller;

import static lotto.model.Winning.*;

import java.util.List;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.model.Winning;
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

    public void inputAndConfirmWinningNumber() {
        List<Integer> winningNumber = view.inputWinningNumber();
        int bonusNumber = view.inputBonusNumber();
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
