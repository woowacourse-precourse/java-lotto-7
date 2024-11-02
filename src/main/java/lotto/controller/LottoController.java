package lotto.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class LottoController {
    private static final String WINNING_DELIMITER = ",";
    private final Lottos lottos;
    private final LottoView view;
    private final LottoValue lottoValue;

    public LottoController(Lottos lottos, LottoView view) {
        this.lottos = lottos;
        this.view = view;
        this.lottoValue = createLottoValue();
    }

    public void startLotto() {
        view.printLottoCount(lottoValue.lottoCount());
        allocateLottoNumbers(lottoValue.lottoCount());
        view.printLottoNumbers(lottos.toStringAllLottoNumber());
    }

    public void winningNumber() {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        confirmWinning(winningNumber, bonusNumber);
        traceWinning(lottos.toStringWinningMessageAndCount());
        view.printWinningRate(getWinningRate(lottoValue.lottoPrice()));
    }

    private LottoValue createLottoValue() {
        BigDecimal lottoPrice = new BigDecimal(Integer.parseInt(view.inputLottoPrice()));
        return new LottoValue(lottoPrice);
    }

    private void allocateLottoNumbers(int lottoCount) {
        lottos.allocateLottosByRandomNumber(lottoCount);
    }

    private List<Integer> inputWinningNumber() {
        String winningNumber = view.inputWinningNumber();
        return Arrays.stream(winningNumber.split(WINNING_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private int inputBonusNumber() {
        return Integer.parseInt(view.inputBonusNumber());
    }

    private void confirmWinning(List<Integer> winningNumber, int bonusNumber) {
        lottos.winningByWinningAndBonusNumber(winningNumber, bonusNumber);
    }

    private void traceWinning(String trace) {
        view.printWinningTrace(trace);
    }

    private String getWinningRate(BigDecimal lottoPrice) {
        return lottos.calculateWinningRate(lottoPrice).toPlainString();
    }
}
