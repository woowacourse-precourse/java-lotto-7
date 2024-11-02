package lotto.controller;

import lotto.domain.Lotto;
import lotto.util.LottoConstant;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public void run() {
        int amount = inputView.readPurchaseAmount();

        List<Lotto> lottos = createLottos(amount);
    }

    private List<Lotto> createLottos(int amount) {
        int count = amount / LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue();

        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }
}
