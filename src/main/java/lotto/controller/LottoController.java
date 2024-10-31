package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lottos;

public class LottoController {
    private final Lottos lottos;

    public LottoController(Lottos lottos) {
        this.lottos = lottos;
    }

    public BigDecimal readPrice() {
        return new BigDecimal(Integer.parseInt(Console.readLine()));
    }

    public int lottoCount(BigDecimal price) {
        return price.divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP)
                .intValue();
    }

    public void allocateLottoNumbers(int lottoCount) {
        lottos.allocateLottosByRandomNumber(lottoCount);
    }

    public String printLottoNumbers() {
        return lottos.toStringAllLottoNumber();
    }

    public List<Integer> inputWinningNumber() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public void confirmWinning(List<Integer> winningNumber, int bonusNumber) {
        lottos.winningByWinningAndBonusNumber(winningNumber, bonusNumber);
    }

    public String traceWinning() {
        return lottos.toStringWinningMessageAndCount();
    }

    public String getWinningRate(BigDecimal lottoPrice) {
        return lottos.calculateWinningRate(lottoPrice).toPlainString();
    }
}
