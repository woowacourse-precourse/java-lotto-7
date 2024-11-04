package lotto.controller;

import static lotto.model.Winning.toStringWithoutNone;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningValue;
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
        IntStream.range(0, lottoValue.lottoCount()).forEach(i -> putLottos());
        view.printLottoNumbers(lottos.toStringAllLottoNumber());
    }

    private void putLottos() {
        lottos.allocateLottosByRandomNumber(
                Randoms.pickUniqueNumbersInRange(1, 45, 6),
                Lotto::new);
    }

    public WinningNumbers getWinningNumber() {
        return new WinningNumbers(view.inputWinningNumber());
    }

    public int getBonusNumber() {
        return view.inputBonusNumber();
    }

    public void confirmWinning(WinningValue winningValue) {
        lottos.setByCorrectCount(winningValue.winningNumbers(), winningValue.bonusNumber());
        view.printWinningTrace(toStringWithoutNone());
    }

    public void printAndCalculateWinningRate() {
        BigDecimal winningRate = getWinningRate();
        String formatRate = formatString(winningRate);
        view.printWinningRate(formatRate);
    }

    private String formatString(BigDecimal winningRate) {
        DecimalFormat df = new DecimalFormat("#,###0.0");
        return df.format(winningRate);
    }

    private BigDecimal getWinningRate() {
        return lottos.calculateWinningRate(lottoValue.lottoPrice());
    }
}
