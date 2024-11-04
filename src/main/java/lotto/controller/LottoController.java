package lotto.controller;

import java.util.List;
import java.util.Objects;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Payment;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.Generator;
import lotto.view.OutputView;

public class LottoController {

    private final InputController inputController;
    private final OutputView outputView;
    private final Generator<Lotto> generator;

    public LottoController(InputController inputController, OutputView outputView, Generator<Lotto> generator) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        Payment payment = inputController.getPayment();
        List<Lotto> lottos = buyLottos(payment);

        WinningLotto winningLotto = inputController.getWinningLotto();

        List<Rank> ranks = calculateRank(lottos, winningLotto);
        LottoResult result = LottoResult.createResult(ranks);

        outputView.printWinningStatic(result.getResults());
        outputView.printProfitRate(result.calculateRevenueRate(payment.getPayment()));
    }

    private List<Lotto> buyLottos(Payment payment) {
        LottoMachine lottoMachine = LottoMachine.buyLotto(payment.getLottoAmount(), generator);
        outputView.printPurchasedLotto(payment.getLottoAmount(), lottoMachine.toLottos());
        return lottoMachine.getLottos();
    }

    private List<Rank> calculateRank(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::getRank)
                .filter(Objects::nonNull)
                .toList();
    }

}
