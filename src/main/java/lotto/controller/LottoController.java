package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class LottoController {
    private final Lottos lottos;
    private final LottoView view;

    public LottoController(Lottos lottos, LottoView view) {
        this.lottos = lottos;
        this.view = view;
    }

    public BigDecimal startLotto() {
        BigDecimal lottoPrice = view.inputLottoPrice();
        int lottoCount = lottoCount(lottoPrice);
        view.printLottoCount(lottoCount);
        allocateLottoNumbers(lottoCount);
        view.printLottoNumbers(lottos.toStringAllLottoNumber());
        return lottoPrice;
    }

    public void winningNumber(BigDecimal lottoPrice) {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        confirmWinning(winningNumber, bonusNumber);
        traceWinning(lottos.toStringWinningMessageAndCount());
        view.printWinningRate(getWinningRate(lottoPrice));
    }


    private int lottoCount(BigDecimal price) {
        return price.divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP)
                .intValue();
    }

    private void allocateLottoNumbers(int lottoCount) {
        lottos.allocateLottosByRandomNumber(lottoCount);
        lottos.ascAllLottoNumber();
    }

    private List<Integer> inputWinningNumber() {
        String winningNumber = view.inputWinningNumber();
        return Arrays.stream(winningNumber.split(","))
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
